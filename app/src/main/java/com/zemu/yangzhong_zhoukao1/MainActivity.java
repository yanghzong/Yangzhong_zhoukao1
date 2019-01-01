package com.zemu.yangzhong_zhoukao1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;*/


public class MainActivity extends AppCompatActivity {

    String url_jing = "http://img0.imgtn.bdimg.com/it/u=3385748430,3965041078&fm=26&gp=0.jpg";
    String url_dong = "http://img.99danji.com/uploadfile/2017/0709/20170709112056389.gif";

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.sdw)
    SimpleDraweeView sdw;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.sdw1)
    SimpleDraweeView sdw1;
    @BindView(R.id.sdw2)
    SimpleDraweeView sdw2;
    private GenericDraweeHierarchyBuilder builder;
    private GenericDraweeHierarchy mHierarchy;
    private GenericDraweeHierarchy mHierarchy1;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new GenericDraweeHierarchyBuilder(getResources());
        bind = ButterKnife.bind(this);

    }

    @OnClick(R.id.btn1)
    public void onBtn1Clicked() {
        //圆形图fresco:roundedCornerRadius="200dp"
        sdw.setImageURI(url_jing);
        sdw.setVisibility(View.VISIBLE);
        sdw1.setVisibility(View.GONE);
        sdw2.setVisibility(View.GONE);

    }

    @OnClick(R.id.btn2)
    public void onBtn2Clicked() {
        //圆角:7DP
        sdw1.setImageURI(url_jing);
        sdw.setVisibility(View.GONE);
        sdw1.setVisibility(View.VISIBLE);
        sdw2.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn3)
    public void onBtn3Clicked() {
        //宽高比   1:2
        sdw2.setImageURI(url_jing);
        sdw.setVisibility(View.GONE);
        sdw1.setVisibility(View.GONE);
        sdw2.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.btn4)
    public void onBtn4Clicked() {
        //加载动图
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(url_dong)
                .setAutoPlayAnimations(true)
                .build();
        sdw.setController(build);
        sdw.setVisibility(View.VISIBLE);
        sdw1.setVisibility(View.GONE);
        sdw2.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn5)
    public void onBtn5Clicked() {
        //获取注解的值
        boolean present = ZhuJie.class.isAnnotationPresent(DraweeViewAnimortation.class);
        DraweeViewAnimortation animortation = ZhuJie.class.getAnnotation(DraweeViewAnimortation.class);
        Toast.makeText(this,""+animortation.name(),Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn6)
    public void onBtn6Clicked() {
        //反射添加集合
        Toast.makeText(this,"一个单独的类执行",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
