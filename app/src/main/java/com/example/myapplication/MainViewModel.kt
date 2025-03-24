package com.example.myapplication

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.ActivityLearnWordBinding
import java.lang.reflect.Array

class MainViewModel: ViewModel() {
    val trainer1 = WordsLearnTrainer()

    val LiveDataAnswer = MutableLiveData<String>()
    val LiveData1 = MutableLiveData<String>()
    val LiveData2 = MutableLiveData<String>()
    val LiveData3 = MutableLiveData<String>()
    val LiveData4 = MutableLiveData<String>()

    val liveDataColor = MutableLiveData<Int>()
    val liveDataBack = MutableLiveData<Int>()
    val liveDataText = MutableLiveData<String>()
    val liveDataIcon = MutableLiveData<Int>()

    val liveDataResult = MutableLiveData<Boolean>()
    val liveDataResultBack1 = MutableLiveData<Int>()
    val liveDataResultBack2 = MutableLiveData<Int>()
    val liveDataResultBack3 = MutableLiveData<Int>()
    val liveDataResultBack4 = MutableLiveData<Int>()


    init {
        show(trainer1)
    }

    fun show(trainer: WordsLearnTrainer) {
        val liveDataQuestion: Question? = trainer.getNextQuestion()
        if (liveDataQuestion != null) {
            LiveDataAnswer.value = liveDataQuestion.correctAnswer.original
            LiveData1.value = liveDataQuestion.variants[0].translate
            LiveData2.value = liveDataQuestion.variants[1].translate
            LiveData3.value = liveDataQuestion.variants[2].translate
            LiveData4.value = liveDataQuestion.variants[3].translate

            liveDataResult.value = false
            liveDataResultBack1.value = R.color.TextVariantColor
            liveDataResultBack2.value = R.color.TextVariantColor
            liveDataResultBack3.value = R.color.TextVariantColor
            liveDataResultBack4.value = R.color.TextVariantColor

        }
    }
    fun сhoice(
        context: Context,
        id: Int,
        trainer: WordsLearnTrainer,
        tvAnswer: TextView,
    ) {
        if (trainer.checkAnswer(id)){
            tvAnswer.setTextColor(ContextCompat.getColor(
                context, R.color.CorrectColor))
            showResult(true, context)
        } else{
            tvAnswer.setTextColor(ContextCompat.getColor(
                context, R.color.WrongColor))
            showResult(false, context)
        }
        liveDataResult.value = true

        if (id == 0) {
            liveDataResultBack1.value = tvAnswer.currentTextColor
        }
        if (id == 1) {
            liveDataResultBack2.value = tvAnswer.currentTextColor
        }
        if (id == 2) {
            liveDataResultBack3.value = tvAnswer.currentTextColor
        }
        if (id == 3) {
            liveDataResultBack4.value = tvAnswer.currentTextColor
        }
    }
    fun showResult(isCorrect: Boolean, context: Context,){
        if (isCorrect){
            liveDataColor.value = ContextCompat.getColor(
                context, R.color.CorrectColor
            )
            liveDataBack.value = ContextCompat.getColor(
                context, R.color.CorrectColor
            )
            liveDataText.value = ContextCompat.getString(
                context, R.string.tittle_correct
            )
            liveDataIcon.value = R.drawable.ic_correct
        } else{
            liveDataColor.value = ContextCompat.getColor(
                context, R.color.WrongColor
            )
            liveDataBack.value = ContextCompat.getColor(
                context, R.color.WrongColor
            )
            liveDataText.value = ContextCompat.getString(
                context, R.string.tittle_wrong
            )
            liveDataIcon.value = R.drawable.ic_wrong
        }
    }
}