package com.chaitanya.remotesearch.di.module.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chaitanya.remotesearch.di.qualifier.ViewModelKey
import com.chaitanya.remotesearch.presentation.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Chaitanya Aggarwal on 28/5/2020.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    /*
    * This method basically says
    * inject this object into a Map using the @IntoMap annotation,
    * with the  AuthViewModel.class as key,
    * and a Provider that will build a AuthViewModel
    * object.
    *
    * */

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

}