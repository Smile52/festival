package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.example.festival.ChooseMsgActivity;
import com.example.festival.R;

import bean.FesivalLab;
import bean.Festival;

/**
 * Created by 九龙 on 2015/10/15.
 */
public class FestivalCategoryFragment extends Fragment {
    public static final String ID_FESTIVAL="festival_id";
    private GridView mGridView;
    private ArrayAdapter<Festival> mAdapter;
    private  LayoutInflater mInflater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.festival_category,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mInflater=LayoutInflater.from(getActivity());
       mGridView= (GridView) view.findViewById(R.id.id_gv_festival_category);
        //第一个参数 上下文  第二个 item布局，第三个数据
       mGridView.setAdapter(mAdapter=new ArrayAdapter<Festival>(getActivity(),-1, FesivalLab.getmInstance().getmFestivals()){
           @Override
           public View getView(int position, View convertView, ViewGroup parent) {
               if(convertView==null){
                   convertView=mInflater.inflate(R.layout.iteam_festival,parent,false);
               }
               TextView tv= (TextView) convertView.findViewById(R.id.id_tv_festival_name);
               tv.setText(getItem(position).getName());
               return convertView;
           }
       });
        //设置每个item的点击事件
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ChooseMsgActivity.class);//跳转到选择信息页面
                intent.putExtra(ID_FESTIVAL,mAdapter.getItem(position).getId());//将点击的哪个节日的ID传过去
                startActivity(intent);
            }
        });

    }
}
