package com.bawei.kanjiale20200319.base;

import java.lang.ref.WeakReference;

/**
 * <p>文件描述：<p>
 * <p>作者：冷瞳<p>
 * <p>创建时间：2020/03/19<p>
 * <p>更改时间：2020/03/19<p>
 * <p>版本号：1<p>
 */
public abstract class BasePresenter <M extends IBaseModel,V extends IBaseView> {
    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        //初始化model层
        model=initModel();
    }
    public void attach(V v){
        weakReference =new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract M initModel();
}
