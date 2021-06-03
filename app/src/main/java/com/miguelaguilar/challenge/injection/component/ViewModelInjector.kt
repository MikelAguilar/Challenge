package com.miguelaguilar.challenge.injection.component

import com.miguelaguilar.challenge.injection.module.NetworkModule
import com.miguelaguilar.challenge.ui.viewModel.GeneralViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    fun inject(vm: GeneralViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}