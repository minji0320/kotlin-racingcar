package racingcar

import kotlin.random.Random

class RacingGame {
    private val moveHistories: MutableList<MoveHistory> = ArrayList()

    fun startRace(carCount: Int, tryCount: Int): MutableList<MoveHistory> {
        for (carIdx in 0 until carCount) {
            moveHistories.add(MoveHistory())
            for (round in 0 until tryCount) {
                moveHistories[carIdx].log(getMoveDistance())
            }
        }

        return moveHistories
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
}
