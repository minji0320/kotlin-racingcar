package racingcar.view

import racingcar.MoveHistory

class ResultView(private val tryCount: Int, private val moveHistories: MutableList<MoveHistory>) {
    fun showRaceResult() {
        println("실행결과")
        for (idx in 0 until tryCount) {
            showRaceResultByIndex(idx)
            println("")
        }
    }

    private fun showRaceResultByIndex(idx: Int) {
        moveHistories.forEach {
            println(it.getProgressBar(idx))
        }
    }
}
