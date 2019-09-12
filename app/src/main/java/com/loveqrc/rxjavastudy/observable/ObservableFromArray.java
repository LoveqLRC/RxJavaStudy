package com.loveqrc.rxjavastudy.observable;

import com.loveqrc.rxjavastudy.Observable;
import com.loveqrc.rxjavastudy.Observer;
import com.loveqrc.rxjavastudy.disposables.Disposable;

/**
 * Created by Rc on 2019-09-12
 */
public class ObservableFromArray<T> extends Observable<T> {
    T[] array;

    public ObservableFromArray(T[] array) {
        this.array = array;
    }


    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable<T> d = new FromArrayDisposable<>(observer, array);

        observer.onSubscribe(d);
        d.run();
    }

    class FromArrayDisposable<T> implements Disposable {

        final Observer<? super T> downstream;

        final T[] array;

        volatile boolean disposed;

        FromArrayDisposable(Observer<? super T> actual, T[] array) {
            this.downstream = actual;
            this.array = array;
        }


        @Override
        public void dispose() {
            disposed = true;
        }

        @Override
        public boolean isDisposed() {
            return disposed;
        }


        void run() {
            T[] a = array;
            int n = a.length;

            for (int i = 0; i < n && !isDisposed(); i++) {
                T value = a[i];
                if (value == null) {
                    downstream.onError(new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                downstream.onNext(value);
            }
            if (!isDisposed()) {
                downstream.onComplete();
            }
        }
    }

}
