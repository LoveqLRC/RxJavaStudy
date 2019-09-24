package com.loveqrc.rxjavastudy.observable;

import androidx.annotation.NonNull;

import com.loveqrc.rxjavastudy.ObservableSource;
import com.loveqrc.rxjavastudy.Observer;
import com.loveqrc.rxjavastudy.functions.Function;
import com.loveqrc.rxjavastudy.observers.BasicFuseableObserver;

/**
 * Created by Rc on 2019-09-16
 */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> function;


    public ObservableMap(ObservableSource<T> source, Function<? super T, ? extends U> function) {
        super(source);
        this.function = function;
    }


    @Override
    protected void subscribeActual(Observer<? super U> observer) {
        source.subscribe(new MapObserver<T, U>(observer, function));
    }

    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> mapper;


        public MapObserver(Observer<? super U> downstream, Function<? super T, ? extends U> mapper) {
            super(downstream);
            this.mapper = mapper;
        }


        @Override
        public void onNext(@NonNull T t) {

            U v;
            try {
                v = mapper.apply(t);
            } catch (Throwable e) {
                fail(e);
                return;
            }
            downstream.onNext(v);


        }
    }


}
