package com.melelee.rxjava1;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * 第一个例子
 *
 * @author mengll
 * @create 2018-11-28 19:51
 **/
public class Demo {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("this is a message 1");//发送第一条信息
                subscriber.onNext("this is a message 2");//发送第二条信息
                subscriber.onCompleted();//发送完成
            }
        });

        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Observer...onCompleted....");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println("Observer...onNext...." + s);
            }
        };
        Subscription subscription = observable.subscribe(stringObserver);
    }
}
