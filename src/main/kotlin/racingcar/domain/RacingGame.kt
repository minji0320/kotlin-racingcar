package racingcar.domain

import kotlin.random.Random

class RacingGame(private val carNames: MutableList<String>, private val tryCount: Int) {
    private val cars: MutableList<Car> = ArrayList()

    fun startRace() {
        initCars()
    }

    private fun initCars() {
        carNames.forEach {
            cars.add(Car(it))
        }
    }

    fun getRandomNum(): Int {
        return Random.nextInt(10)
    }

    private fun getMoveDistance(): Int {
        return if (isMove(getRandomNum())) 1 else 0
    }

    fun isMove(randomNum: Int): Boolean {
        return randomNum >= 4
    }

    private fun moveCar(carIdx: Int, tryCount: Int) {
        // moveHistories.add(MoveHistory())
        // for (round in 0 until tryCount) {
        //     moveHistories[carIdx].log(getMoveDistance())
        // }
    }
}
