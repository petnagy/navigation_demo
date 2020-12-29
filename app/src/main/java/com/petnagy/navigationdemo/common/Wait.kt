package com.petnagy.navigationdemo.common

import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import java.util.concurrent.TimeUnit

fun wait(delay: Long, action: () -> Unit) {
    Completable.timer(delay, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
        .doOnComplete {
            action()
        }.subscribe()
}
