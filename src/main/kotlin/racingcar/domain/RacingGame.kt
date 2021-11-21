package racingcar.domain

import kotlin.random.Random

class RacingGame(private val carNames: MutableList<String>) {
    val cars: MutableList<Car> = ArrayList()
    private var maxDistance = 0
    private var winners = mutableListOf<String>()

    fun initCars() {
        carNames.forEach {
            cars.add(Car(it))
        }
    }

    fun moveCars(): MutableList<Car> {
        cars.forEach {
            it.move(getMoveDistance())
        }

        return cars
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

    fun getWinners(): MutableList<String> {
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
