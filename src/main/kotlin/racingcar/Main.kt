package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView

fun main() {
    val inputView = InputView()
    val racingGame = RacingGame(inputView.readCarNames(), inputView.readTryCount())

    racingGame.startRace()
}
