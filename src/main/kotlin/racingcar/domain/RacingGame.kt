package racingcar.domain

import racingcar.view.ResultView
import kotlin.random.Random

class RacingGame(private val carNames: MutableList<String>, private val tryCount: Int) {
    private val cars: MutableList<Car> = ArrayList()
    private val resultView = ResultView()

    fun startRace() {
        initCars()

        resultView.showStartRace()
        for (i in 0 until tryCount) {
            moveCars()
            resultView.showNowRaceResult(cars)
        }
    }

    private fun initCars() {
        carNames.forEach {
            cars.add(Car(it))
        }
    }

    private fun moveCars() {
        cars.forEach {
            it.move(getMoveDistance())
        }
    }

    private fun getMoveDistance(): Int {
        return if (isMove(getRandomNum())) 1 else 0
    }

    fun isMove(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    fun getRandomNum(): Int {
        return Random.nextInt(10)
    }
}
