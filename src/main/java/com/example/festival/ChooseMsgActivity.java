package com.example.festival;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

import bean.FesivalLab;
import bean.Msg;
import fragment.FestivalCategoryFragment;

/**短信选择activity
 * Created by 九龙 on 2015/10/15.
 */
public class ChooseMsgActivity extends AppCompatActivity {
    private ListView mLvMsgs;
    private FloatingActionButton mFabToSend;
    private ArrayAdapter<Msg> mAdapter;
    private int mFestivalId;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);

        mInflater= LayoutInflater.from(this);
        mFestivalId=getIntent().getIntExtra(FestivalCategoryFragment.ID_FESTIVAL, -1);//拿到传过来的mFestivalId
        setTitle(FesivalLab.getmInstance().getFestivalById(mFestivalId).getName());
        initViews();
        initEvent();
    }

    private void initEvent() {
        mFabToSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMsgActivity.toActivity(ChooseMsgActivity.this,mFestivalId,-1);
            }
        });
    }

    private void initViews() {
        mLvMsgs= (ListView) findViewById(R.id.id_lv_msgs);
        mFabToSend= (FloatingActionButton) findViewById(R.id.id_fab_toSend);

        mLvMsgs.setAdapter(mAdapter=new ArrayAdapter<Msg>(this,-1, FesivalLab.getmInstance().getmMgsByFestivalId(mFestivalId))
        {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                if(convertView==null){
                    convertView=mInflater.inflate(R.layout.item_msg,parent,false);
                }
                TextView content= (TextView) convertView.findViewById(R.id.id_tv_content);
                Button tosend= (Button) convertView.findViewById(R.id.id_btn_send);
                content.setText("  "+getItem(position).getContent());
                tosend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击跳转到发送短信activity
                        SendMsgActivity.toActivity(ChooseMsgActivity.this,mFestivalId,getItem(position).getId());
                    }
                });
                return convertView;
            }
        });

    }
}
