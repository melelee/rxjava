package com.melelee.rxjava2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * rxjava2 demo
 *
 * @author mengll
 * @create 2018-11-28 20:52
 **/
public class Demo {
    public static void main(String[] args) {
        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("onnext");
                observableEmitter.onComplete();
            }
        });



        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("onSubscribe...");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext..."+s);

            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete...");
            }
        };


        stringObservable.subscribe(stringObserver);
    }
}
