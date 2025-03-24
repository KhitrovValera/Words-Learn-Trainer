package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityLearnWordBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityLearnWordBinding
    private val mainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private lateinit var mediator: Mediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val trainer = mainViewModel.trainer1

        mediator = Mediator(mainViewModel, this)
        mediator.setupMediation()

        with(binding) {
            btnContinue.setOnClickListener {
                mediator.onClickContinue()
                layoutResult.isVisible = false
            }
            btnSkip.setOnClickListener {
                mediator.onClickSkip()
            }
            layoutAnswer1.setOnClickListener {
                mediator.onAnswerClick(0, trainer, tvAnswer1)
            }

            layoutAnswer2.setOnClickListener {
                mediator.onAnswerClick(1, trainer, tvAnswer2)
            }

            layoutAnswer3.setOnClickListener {
                mediator.onAnswerClick(2, trainer, tvAnswer3)
            }

            layoutAnswer4.setOnClickListener {
                mediator.onAnswerClick(3, trainer, tvAnswer4)
            }
        }
    }
}
