package fragment;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.festival.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import bean.SendedMsg;
import db.SmsProvider;
import view.FlowLayout;

/**历史信息Fragment
 * Created by 九龙 on 2015/10/20.
 */
public class SmsHistoryFragment extends ListFragment {
    private static final int LOADER_ID=1;
    private LayoutInflater mInflater;
    private CursorAdapter mCursorAdapter;

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment,container,false);
    }*/

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInflater=LayoutInflater.from(getActivity());

        initLoader();
        setupListAdapter();
    }

    private void setupListAdapter() {
        mCursorAdapter=new CursorAdapter(getActivity(),null,false) {
            //返回一个Item布局
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                View view=mInflater.inflate(R.layout.item_sended_msg,parent,false);
                return view;
            }
            //设置数据
            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                //绑定控件
                TextView msg= (TextView) view.findViewById(R.id.id_tv_msg);
                FlowLayout fl= (FlowLayout) view.findViewById(R.id.id_fl_contacts);
                TextView fes= (TextView) view.findViewById(R.id.id_tv_fes);
                TextView data= (TextView) view.findViewById(R.id.id_tv_date);
                //赋值
                msg.setText(cursor.getString(cursor.getColumnIndex(SendedMsg.COLUMN_MSG)));
                fes.setText(cursor.getString(cursor.getColumnIndex(SendedMsg.COLUMN_FESTIVALNAME)));
                long dataval=cursor.getLong(cursor.getColumnIndex(SendedMsg.COLUMN_DATE));
                data.setText(paresDate(dataval));

              /*  data.setText(cursor.getString(cursor.getColumnIndex(SendedMsg.COLUMN_DATE)));*/
                String names=cursor.getString(cursor.getColumnIndex(SendedMsg.COLUMN_NAMES));
                if(TextUtils.isEmpty(names)){
                    return;
                }
                fl.removeAllViews();
                for(String name : names.split(":") ){
                    addflg(name,fl);
                }

            }
        };
        setListAdapter(mCursorAdapter);//添加adapter
    }

    /**
     * 将时间戳转换为时间
     * @param dataval
     * @return
     */
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private String paresDate(long dataval) {

        return df.format(dataval);
    }

    private void addflg(String name, FlowLayout fl) {
        TextView tv= (TextView) mInflater.inflate(R.layout.tag,fl,false);
        tv.setText(name);
        fl.addView(tv);
    }

    private void initLoader() {
        getLoaderManager().initLoader(LOADER_ID, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                CursorLoader loader=new CursorLoader(getActivity(), SmsProvider.URI_SMS_ALL,null,null,null,null);
                return loader;
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                if(loader.getId()==LOADER_ID){
                    mCursorAdapter.swapCursor(data);
                }
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {
                mCursorAdapter.swapCursor(null);
            }
        });

    }
}
