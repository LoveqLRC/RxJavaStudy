package com.loveqrc.rxjavastudy.functions;

import androidx.annotation.NonNull;

/**
 * Created by Rc on 2019-09-16
 */
public interface Function<T, R> {

    R apply(@NonNull T t) throws Exception;
}
