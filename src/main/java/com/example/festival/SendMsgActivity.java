package com.example.festival;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.HashSet;

import bean.FesivalLab;
import bean.Festival;
import bean.Msg;
import bean.SendedMsg;
import biz.SmsBiz;
import view.FlowLayout;

/**
 * 发送短信activity
 */
public class SendMsgActivity extends AppCompatActivity {
    public static final String KEY_FESTIVALID= "festivalId";
    public static final String KEY_MSGID="msgId";
    private static final int REQUEST_CODE = 1;
    private int mFestivalId;
    private int mMsgId;
    private Festival mFestival;
    private Msg msg;
    private LayoutInflater mInflater;
    private EditText mEdMsg;
    private Button mBtnAdd;
    private FlowLayout mFlContacts;
    private FloatingActionButton mFabSend;
    private View mLayoutLoading;
    private HashSet<String> mcontactNames=new HashSet<>();
    private HashSet<String> mcontactNums=new HashSet<>();
    private  static final String ACTION_SEND_MSG="ACTION_SEND_MSG";
    private  static final String ACTION_DELIVER_MSG="ACTION_DELIVER_MSG";

    private PendingIntent mSendPi;
    private PendingIntent mDeliverPi;
    private BroadcastReceiver mSendBoradcastReceiver;
    private BroadcastReceiver mDeliverBoradcastReceiver;

    private SmsBiz smsBiz;
    private int mMsgSendCount;
    private  int mTotalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg_activity);
        mInflater=LayoutInflater.from(this);
        smsBiz=new SmsBiz(this);
        initData();
        initViews();
        initEvents();
        initReceiver();

    }
    //初始化广播
    private void initReceiver() {
        Intent sendIntent=new Intent(ACTION_SEND_MSG);
        mSendPi=PendingIntent.getBroadcast(this,0,sendIntent,0);
        Intent deliverIntent=new Intent(ACTION_DELIVER_MSG);
        mDeliverPi=PendingIntent.getBroadcast(this,0,deliverIntent,0);
        registerReceiver(mSendBoradcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mMsgSendCount++;
                if (getResultCode() == RESULT_OK) {
                    Log.e("TAG", "短信发送成功" + (mMsgSendCount + "/" + mTotalCount));
                } else {
                    Log.e("TAG", "短信发送失败");
                }
                Toast.makeText(SendMsgActivity.this, (mMsgSendCount + "/" + mTotalCount) + "短信发送成功", Toast.LENGTH_SHORT).show();

                if (mMsgSendCount == mTotalCount) {
                    finish();
                }
            }
        }, new IntentFilter(ACTION_SEND_MSG));
        registerReceiver(mDeliverBoradcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("TAG", "联系人已经成功接收到短信");
            }
        }, new IntentFilter(ACTION_DELIVER_MSG));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mSendBoradcastReceiver);//最后注销广播
        unregisterReceiver(mDeliverBoradcastReceiver);
    }

    private void initEvents() {
        //点击 读取联系人
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);//打开系统通讯录
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
        //发送短信
        mFabSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcontactNums.size() == 0) {
                    Toast.makeText(SendMsgActivity.this, "请先选择联系人", Toast.LENGTH_SHORT).show();
                    return;
                }
                String msg = mEdMsg.getText().toString();//短信内容
                if (TextUtils.isEmpty(msg)) {
                    Toast.makeText(SendMsgActivity.this, "短信内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mLayoutLoading.setVisibility(View.VISIBLE);//显示加载读条
                mTotalCount = smsBiz.sendMsg(mcontactNums, buildSendMsg(msg), mSendPi, mDeliverPi);//调用方法来发送短信
                mMsgSendCount = 0;
            }
        });
    }

    private SendedMsg buildSendMsg(String msg) {
        SendedMsg sendedMsg=new SendedMsg();
        sendedMsg.setMsg(msg);
        sendedMsg.setFestivalName(mFestival.getName());
        String names="";
        for(String name :mcontactNames){
            names+=name+":";//多个联系人用：分割
        }
        String numbers="";
        for(String number :mcontactNums){
            numbers+=number+":";
        }
        sendedMsg.setNumbers(numbers.substring(0,numbers.length()-1));
        sendedMsg.setNames(names.substring(0,names.length()-1));//将最后的：去掉

        return sendedMsg;
    }

    private void initViews() {
        mEdMsg= (EditText) findViewById(R.id.id_et_content);
        mBtnAdd= (Button) findViewById(R.id.id_btn_add);
        mFlContacts= (FlowLayout) findViewById(R.id.id_fl_content);
        mFabSend= (FloatingActionButton) findViewById(R.id.id_fab_send);
        mLayoutLoading=findViewById(R.id.id_layout_loading);
        mLayoutLoading.setVisibility(View.GONE);//设置默认为隐藏
        if(mMsgId!=-1){
            msg=FesivalLab.getmInstance().getmMgsById(mMsgId);
            mEdMsg.setText(msg.getContent());

        }
    }

    private void initData() {
        mFestivalId=getIntent().getIntExtra(KEY_FESTIVALID,-1);
        mMsgId=getIntent().getIntExtra(KEY_MSGID,-1);
        mFestival=FesivalLab.getmInstance().getFestivalById(mFestivalId);
        setTitle(mFestival.getName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是否为开始我们传过去的参数
        if (requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                Uri contactUri=data.getData();
                Cursor cursor =getContentResolver().query(contactUri, null, null, null, null);//通过contactUri查询,返回游标对象
                cursor.moveToFirst();
                String contactName=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));//拿到联系人名字
                String number=getContactsNum(cursor);
                Log.v("tga", contactName);
                //判断是否为空字符串
                if(!TextUtils.isEmpty(number)){
                    mcontactNums.add(number);
                    mcontactNames.add(contactName);
                    Log.v("tga", contactName);
                    addTag(contactName);
                }
            }
        }
    }

    /**
     * 界面显示联系人的名字
     * @param contactName
     */
    private void addTag(String contactName) {
        TextView view = (TextView) mInflater.inflate(R.layout.tag,mFlContacts,false);
        view.setText(contactName);
        mFlContacts.addView(view);
    }

    //获取联系人号码
    private String getContactsNum(Cursor cursor) {
        int numCount =cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
        String number=null;
        if(numCount>0){
            int contactId = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phoneCursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null, null);
            phoneCursor.moveToFirst();//游标移到第一列
            number=phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            phoneCursor.close();
            return  number;
        }
        cursor.close();
        return number;
    }

    public static void toActivity(Context context,int festivalId,int msgId){
        Intent intent=new Intent(context,SendMsgActivity.class);
        intent.putExtra(KEY_FESTIVALID,festivalId);
        intent.putExtra(KEY_MSGID,msgId);
        context.startActivity(intent);

    }

}
