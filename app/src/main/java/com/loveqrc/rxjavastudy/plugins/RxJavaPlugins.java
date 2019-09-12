package com.loveqrc.rxjavastudy.plugins;

import com.loveqrc.rxjavastudy.Observable;
import com.loveqrc.rxjavastudy.observable.ObservableFromArray;

/**
 * Created by Rc on 2019-09-12
 */
public class RxJavaPlugins {


    public static <T> Observable<T> onAssembly(Observable<T> source) {
        return source;
    }

}
