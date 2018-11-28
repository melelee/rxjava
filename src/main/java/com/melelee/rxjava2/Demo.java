package com.melelee.rxjava2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * rxjava2 demo
 *
 * @author mengll
 * @create 2018-11-28 20:52
 **/
public class Demo {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                observableEmitter.onNext("onnext");

            }
        });
    }
}
