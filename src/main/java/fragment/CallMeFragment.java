package fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.festival.R;

/**
 * Created by 九龙 on 2015/10/22.
 */
public class CallMeFragment extends Fragment {
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.call_me,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        imageView= (ImageView) view.findViewById(R.id.id_iv_cat);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化一个意图，当按钮被单击时被执行
                Intent intent = new Intent();
                //这个意图就是调用系统的拨打活动
                intent.setAction(Intent.ACTION_CALL);
                //设置要拨打的电话号号码
                intent.setData(Uri.parse("tel:15575818134"));//uriString的格式为“tel:电话号码”
                //开始调整到打电话的活动
                startActivity(intent);

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}
