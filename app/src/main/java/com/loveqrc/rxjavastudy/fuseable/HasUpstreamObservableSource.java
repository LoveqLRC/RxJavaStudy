package com.loveqrc.rxjavastudy.fuseable;

import com.loveqrc.rxjavastudy.ObservableSource;

/**
 * Created by Rc on 2019-09-16
 */
public interface HasUpstreamObservableSource<T> {
    ObservableSource<T> source();
}
