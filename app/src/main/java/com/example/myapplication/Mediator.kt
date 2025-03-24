package com.example.myapplication

import android.widget.TextView
import androidx.core.view.isVisible

class Mediator(private val mainViewModel: MainViewModel, private val activity: MainActivity) {

    fun setupMediation() {
        with(activity.binding) {
            mainViewModel.apply {
                liveDataColor.observe(activity) {
                    btnContinue.setTextColor(it)
                }
                liveDataBack.observe(activity) {
                    layoutResult.setBackgroundColor(it)
                }
                liveDataText.observe(activity) {
                    tvResult.text = it
                }
                liveDataIcon.observe(activity) {
                    ivResultIcon.setImageResource(it)
                }
                liveDataResult.observe(activity) {
                    layoutResult.isVisible = it
                }
                LiveDataAnswer.observe(activity) {
                    tvQuestionWord.text = it
                }
                LiveData1.observe(activity) {
                    tvAnswer1.text = it
                }
                LiveData2.observe(activity) {
                    tvAnswer2.text = it
                }
                LiveData3.observe(activity) {
                    tvAnswer3.text = it
                }
                LiveData4.observe(activity) {
                    tvAnswer4.text = it
                }
                liveDataResultBack1.observe(activity) {
                    tvAnswer1.setTextColor(it)
                }
                liveDataResultBack2.observe(activity) {
                    tvAnswer2.setTextColor(it)
                }
                liveDataResultBack3.observe(activity) {
                    tvAnswer3.setTextColor(it)
                }
                liveDataResultBack4.observe(activity) {
                    tvAnswer4.setTextColor(it)
                }
            }
        }
    }

    fun onClickContinue() {
        mainViewModel.show(mainViewModel.trainer1)
    }

    fun onClickSkip() {
        mainViewModel.show(mainViewModel.trainer1)
    }

    fun onAnswerClick(id: Int, trainer: WordsLearnTrainer, tvAnswer: TextView) {
        mainViewModel.сhoice(activity, id, trainer, tvAnswer)
    }
}
