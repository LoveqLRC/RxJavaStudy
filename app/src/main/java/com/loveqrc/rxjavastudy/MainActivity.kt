package com.loveqrc.rxjavastudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.loveqrc.rxjavastudy.disposables.Disposable
import com.loveqrc.rxjavastudy.functions.Function
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java!!.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sample.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        getObservable()
            .map { t ->
                "Hello :$t"
            }
            .subscribe(getObserver())
    }

    private fun getObservable(): Observable<out String> {
        return Observable.just("Cricket", "Football")
    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed())
            }

            override fun onNext(t: String) {
                Log.d(TAG, " onNext : value : $t")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, " onError : " + e.message)
            }

            override fun onComplete() {
                Log.d(TAG, " onComplete")
            }

        }
    }
}
