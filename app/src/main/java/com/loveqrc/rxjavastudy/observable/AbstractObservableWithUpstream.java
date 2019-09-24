package com.loveqrc.rxjavastudy.observable;

import com.loveqrc.rxjavastudy.Observable;
import com.loveqrc.rxjavastudy.ObservableSource;
import com.loveqrc.rxjavastudy.fuseable.HasUpstreamObservableSource;

/**
 * Created by Rc on 2019-09-16
 *
 * @param <T> the input source type
 * @param <U> the output type
 */
abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> source;

    public AbstractObservableWithUpstream(ObservableSource<T> source) {
        this.source = source;
    }

    @Override
    public ObservableSource<T> source() {
        return source;
    }
}
