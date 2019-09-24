package com.loveqrc.rxjavastudy;


import com.loveqrc.rxjavastudy.functions.Function;
import com.loveqrc.rxjavastudy.observable.ObservableFromArray;
import com.loveqrc.rxjavastudy.observable.ObservableMap;
import com.loveqrc.rxjavastudy.plugins.RxJavaPlugins;

/**
 * Created by Rc on 2019-09-12
 */
public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public final void subscribe(Observer<? super T> observer) {
        try {
            subscribeActual(observer);
        } catch (NullPointerException e) { // NOPMD
            throw e;
        } catch (Throwable e) {
            NullPointerException npe = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            npe.initCause(e);
            throw npe;
        }
    }

    public final <R> Observable<R> map(Function<? super T, ? extends R> mapper) {

        return RxJavaPlugins.onAssembly(new ObservableMap<T, R>(this, mapper));
    }


    protected abstract void subscribeActual(Observer<? super T> observer);


    public static <T> Observable<T> just(T item1, T item2) {
        return fromArray(item1, item2);
    }

    private static <T> Observable<T> fromArray(T... items) {

        return RxJavaPlugins.onAssembly(new ObservableFromArray<T>(items));
    }

}
