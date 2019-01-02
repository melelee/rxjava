package com.melelee.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * DemoBackPressure
 *
 * @author mengll
 * @create 2018 -11-28 20:52
 */
public class DemoBackPressure {
	public static void main(String[] args) {
		Flowable flowable = Flowable.create(new FlowableOnSubscribe<String>() {
			@Override
			public void subscribe(FlowableEmitter<String> e) throws Exception {
				if (!e.isCancelled()) {
					e.onNext("test");
					e.onComplete();
				}
			}
		}, BackpressureStrategy.MISSING);

		Subscriber<String> stringSubscriber = new Subscriber<String>() {
			@Override
			public void onSubscribe(Subscription subscription) {
				subscription.request(Long.MAX_VALUE);
				System.out.println("onSubscribe");
			}

			@Override
			public void onNext(String s) {
				System.out.println("onnext");
			}
			@Override
			public void onError(Throwable throwable) {
				System.out.println("onError");
			}
			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		};

		flowable.subscribe(stringSubscriber);
	}
}
