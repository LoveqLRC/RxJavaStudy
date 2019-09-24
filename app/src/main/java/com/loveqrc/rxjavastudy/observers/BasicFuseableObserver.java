package com.loveqrc.rxjavastudy.observers;

import androidx.annotation.NonNull;

import com.loveqrc.rxjavastudy.Observable;
import com.loveqrc.rxjavastudy.Observer;
import com.loveqrc.rxjavastudy.disposables.Disposable;

/**
 * Created by Rc on 2019-09-16
 */
public abstract class BasicFuseableObserver<T, R> implements Observer<T> {

    protected final Observer<? super R> downstream;
    protected Disposable upstream;

    public BasicFuseableObserver(Observer<? super R> downstream) {
        this.downstream = downstream;
    }


    @Override
    public void onSubscribe(@NonNull Disposable d) {
        upstream = d;
        downstream.onSubscribe(d);
    }


    protected final void fail(Throwable t) {
        upstream.dispose();
        onError(t);
    }


    @Override
    public void onError(@NonNull Throwable e) {
        downstream.onError(e);
    }

    @Override
    public void onComplete() {
        downstream.onComplete();
    }


}
