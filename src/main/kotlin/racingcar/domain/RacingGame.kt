package racingcar.domain

import racingcar.view.ResultView
import kotlin.random.Random

class RacingGame(private val carNames: MutableList<String>, private val tryCount: Int) {
    val cars: MutableList<Car> = ArrayList()
    private val resultView = ResultView()
    private var maxDistance = 0
    private var winners = mutableListOf<String>()

    fun startRace() {
        initCars()

        resultView.showStartRace()
        for (i in 0 until tryCount) {
            moveCars()
            resultView.showNowRaceResult(cars)
        }

        resultView.showWinner(getWinners())
    }

    fun initCars() {
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

    fun getCarCount(): Int {
        return cars.size
    }

    private fun getWinners(): MutableList<String> {
        cars.forEach {
            findWinner(it)
        }
        return winners
    }

    private fun findWinner(car: Car) {
        if (maxDistance < car.position) {
            maxDistance = car.position
            winners = mutableListOf(car.name)
        } else if (maxDistance == car.position) {
            winners.add(car.name)
        }
    }
}
