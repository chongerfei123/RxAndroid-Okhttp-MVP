package com.example.zl.mvpdemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;

import Present.IPresent;
import view.BaseActivity;
import view.IView;

public class MainActivity extends BaseActivity<IView, IPresent> implements IView {

    private ImageView image;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.fetch();
            }
        });

    }

    private void initView() {
        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);
    }


    @Override
    public void showPic(Bitmap bitmap) {
        image.setImageBitmap(bitmap);
    }

    @Override
    public void showLoading() {
        button.setText("正在加载图片");
    }

    public void hideLoading() {
        button.setText("加载完成");
    }

    @Override
    protected IPresent createPresenter() {
        IPresent iPresent = new IPresent(this);
        return iPresent;
    }
}
