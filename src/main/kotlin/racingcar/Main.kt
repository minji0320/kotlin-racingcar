package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carCount = inputView.askCarCount()
    val tryCount = inputView.askTryCount()

    val racingGame = RacingGame()
    val moveHistories = racingGame.startRace(carCount, tryCount)

    val resultView = ResultView(tryCount, moveHistories)
    resultView.showRaceResult()
}
