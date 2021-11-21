package racingcar.view

import racingcar.domain.Car

class ResultView() {
    fun showStartRace() {
        println("실행결과")
    }

    fun showNowRaceResult(cars: MutableList<Car>) {
        cars.forEach {
            println(it.getProgressBar())
        }
        println("")
    }

    fun showWinner(winners: MutableList<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
