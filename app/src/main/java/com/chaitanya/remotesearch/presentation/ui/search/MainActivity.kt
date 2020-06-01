package com.chaitanya.remotesearch.presentation.ui.search

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.chaitanya.remotesearch.BR
import com.chaitanya.remotesearch.R
import com.chaitanya.remotesearch.databinding.ActivityMainBinding
import com.chaitanya.remotesearch.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.layout_search.view.*
import javax.inject.Inject


/**
 * Created by Chaitanya Aggarwal on 28/5/2020.
 */

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        binding.root.rv_suggested_address.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        initObserver()

        viewModel.findAddress()
    }

    private fun initObserver() {
        viewModel.userEntry.observe(this, Observer {
            viewModel.publish(it)
        })
    }

    override fun onDestroy() {
        viewModel.clearDisposables()
        super.onDestroy()
    }


}
