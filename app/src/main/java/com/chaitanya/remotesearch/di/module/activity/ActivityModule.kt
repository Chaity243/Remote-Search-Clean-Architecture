package com.chaitanya.remotesearch.di.module.activity

import com.chaitanya.remotesearch.presentation.ui.search.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Chaitanya Aggarwal on 28/5/2020.
 */

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}