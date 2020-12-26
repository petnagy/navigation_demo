package com.petnagy.navigationdemo.pages.splash

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onResume() {
        super.onResume()
        Completable.timer(2000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
            .doOnComplete {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }.subscribe()
    }
}
