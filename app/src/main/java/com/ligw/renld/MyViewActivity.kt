package com.ligw.renld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ligw.renld.databinding.ActivityMyviewBinding

class MyViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMyviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_myview)
//        //setContentView(R.layout.activity_myview)
        lifecycle.addObserver(binding.view)
    }
}