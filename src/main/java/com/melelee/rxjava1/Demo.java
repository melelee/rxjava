package com.melelee.rxjava1;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

/**
 * 第一个例子
 *
 * @author mengll
 * @create 2018-11-28 19:51
 **/
public class Demo {
	public static void main(String[] args) {
		demo();

		testMap();
	}

	public static void testMap() {
		Subscription subscription = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("1");
				subscriber.onNext("2");
				subscriber.onNext("3");
			}
		}).map(
				new Func1<String, Integer>() {
					@Override
					public Integer call(String s) {
						return Integer.parseInt(s);
					}
				}
		).subscribe(
				new Observer<Integer>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable throwable) {

			}

			@Override
			public void onNext(Integer integer) {
				System.out.println(integer);
			}
		});

		System.out.println(subscription.isUnsubscribed());
	}

	public static void demo() {
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
