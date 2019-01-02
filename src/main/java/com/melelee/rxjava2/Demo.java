package com.melelee.rxjava2;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * rxjava2 demo
 *
 * @author mengll
 * @create 2018-11-28 20:52
 **/
public class Demo {
	public static void main(String[] args) {
		demo();
		testMap();
	}

	public static void testMap() {
		Observable.create(new ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> e) throws Exception {
				e.onNext("1");
				e.onNext("2");
				e.onComplete();

			}
		})
				.map(new Function<String, Integer>() {
			@Override
			public Integer apply(String s) throws Exception {
				return Integer.parseInt(s);
			}
		})
				.subscribe(new Observer<Integer>() {
					@Override
					public void onSubscribe(Disposable d) {
						System.out.println("onSubscribe");
					}

					@Override
					public void onNext(Integer integer) {
						System.out.println(integer);
					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onComplete() {

					}
				});

	}

	public static void demo() {
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
				System.out.println("onNext..." + s);

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
