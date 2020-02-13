package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.entity.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        viewModel.getData()
        initRecycleView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.data.observe(this, Observer {
            adapter = MainAdapter(it)
            adapter.setOnclickListener(object: MainAdapter.OnClickListener{
                override fun onClick(movie: Movie) {
                    Toast.makeText(applicationContext, movie.poster_path, Toast.LENGTH_SHORT).show()
                }

            })
            rv_list.adapter = adapter
        })
    }

    private fun initRecycleView() {
        with(rv_list){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }
}
