package com.loveqrc.rxjavastudy;

import androidx.annotation.NonNull;

import com.loveqrc.rxjavastudy.disposables.Disposable;

/**
 * Created by Rc on 2019-09-12
 */
public interface Observer<T> {
    void onSubscribe(@NonNull Disposable d);


    void onNext(@NonNull T t);


    void onError(@NonNull Throwable e);


    void onComplete();

}
