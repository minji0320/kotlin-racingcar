package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carNames = inputView.readCarNames()
    val tryCount = inputView.readTryCount()

    val racingGame = RacingGame(carNames)

    resultView.showStartRace()
    racingGame.initCars()

    for (i in 0 until tryCount) {
        val nowCars = racingGame.moveCars()
        resultView.showNowRaceResult(nowCars)
    }

    resultView.showWinner(racingGame.getWinners())
}
