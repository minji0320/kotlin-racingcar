package racingcar.domain

import kotlin.random.Random

private const val FORWARD_NUMBER = 4
private const val GO = 1
private const val STOP = 0

class RacingGame(private val carNames: MutableList<String>) {
    val cars: MutableList<Car> = ArrayList()
    private var maxDistance = Car.INIT_POSITION
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
        return if (isMove(getRandomNum())) GO else STOP
    }

    fun isMove(randomNum: Int): Boolean {
        return randomNum >= FORWARD_NUMBER
    }

    fun getRandomNum(): Int {
        return Random.nextInt(UNTIL_RANDOM_NUMBER)
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

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val UNTIL_RANDOM_NUMBER = 10
    }
}
