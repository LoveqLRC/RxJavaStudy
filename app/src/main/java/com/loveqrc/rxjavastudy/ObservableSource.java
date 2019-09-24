package com.loveqrc.rxjavastudy;

import androidx.annotation.NonNull;

/**
 * Created by Rc on 2019-09-16
 */
public interface ObservableSource<T> {

    void subscribe(@NonNull Observer<? super T> observer);

}
