package com.bawei.kanjiale20200319.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * <p>文件描述：<p>
 * <p>作者：冷瞳<p>
 * <p>创建时间：2020/03/19<p>
 * <p>更改时间：2020/03/19<p>
 * <p>版本号：1<p>
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutid());
        presenter=initPresenter(); //初始化p层对象
        if (presenter != null) {
            presenter.attach(this);  //绑定
        }
        initView();   //初始化块控件
        initData();    //初始化数据
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract int bindLayoutid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();  //解绑,释放资源
        }
    }
}
