package com.example.myapplication

class WordsLearnTrainer {
    private val dictionary = listOf(
        Word("Space", "Космос"),
        Word("Sun", "Солнце"),
        Word("Moon", "Луна"),
        Word("Earth", "Земля"),
        Word("Water", "Вода"),
        Word("Fire", "Огонь"),
        Word("Air", "Воздух"),
        Word("Time", "Время"),
        Word("Nature", "Природа"),
        Word("Animal", "Животное"),
        Word("Plant", "Растение"),
        Word("Food", "Еда"),
        Word("Drink", "Напиток"),
        Word("Sport", "Спорт"),
        Word("Music", "Музыка"),
        Word("Art", "Искусство"),
        Word("Science", "Наука"),
        Word("Technology", "Технология"),
        Word("Computer", "Компьютер"),
        Word("Internet", "Интернет"),
    )

    private var currentQuestion: Question? = null

    fun getNextQuestion(): Question? {

        val notLearnedList = dictionary.filter { !it.learned}
        if (notLearnedList.isEmpty()) return null

        val questionWord =
            if (notLearnedList.size < NUMBER_OF_ANSWERS) {
                val learnList = dictionary.filter { it.learned }.shuffled()
                notLearnedList.shuffled()
                    .take(NUMBER_OF_ANSWERS) + learnList
                    .take(NUMBER_OF_ANSWERS - notLearnedList.size)
            } else {
                notLearnedList.shuffled().take((NUMBER_OF_ANSWERS))
            }.shuffled()

        val correctAnswer: Word = questionWord.random()

        currentQuestion = Question(
            variants = questionWord,
            correctAnswer = correctAnswer,
        )
        return currentQuestion
    }

    fun  checkAnswer(userAnswerIndex: Int?): Boolean {

        return currentQuestion?.let {

            val correctAnswerId = it.variants.indexOf(it.correctAnswer)
            if (correctAnswerId == userAnswerIndex) {
                it.correctAnswer.learned = true
                true
            } else {
                false
            }
        } ?: false
    }
}