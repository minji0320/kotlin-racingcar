package racingcar.view

import racingcar.domain.Car

class ResultView() {
    fun showStartRace() {
        println("실행결과")
    }

    fun showNowRaceResult(cars: MutableList<Car>) {
        cars.forEach {
            println("${it.name} : ${it.getProgressBar()}")
        }
        println("")
    }
}
