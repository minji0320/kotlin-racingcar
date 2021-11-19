package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingTest {
    private val racingGame = RacingGame()

    @Test
    fun `랜덤 숫자가 0에서 9 사이의 값인지 체크`() {
        assertThat(racingGame.getRandomNum()).isGreaterThanOrEqualTo(0)
        assertThat(racingGame.getRandomNum()).isLessThan(10)
    }

    @Test
    fun `랜덤 숫자에 따른 이동 여부 체크`() {
        assertThat(racingGame.isMove(0)).isFalse
        assertThat(racingGame.isMove(1)).isFalse
        assertThat(racingGame.isMove(2)).isFalse
        assertThat(racingGame.isMove(3)).isFalse
        assertThat(racingGame.isMove(4)).isTrue
        assertThat(racingGame.isMove(5)).isTrue
        assertThat(racingGame.isMove(6)).isTrue
        assertThat(racingGame.isMove(7)).isTrue
        assertThat(racingGame.isMove(8)).isTrue
        assertThat(racingGame.isMove(9)).isTrue
    }

    @Test
    fun `자동차의 이동 이력을 정상적으로 저장하는지 체크`() {
        val moveHistory = MoveHistory()
        moveHistory.log(1)
        moveHistory.log(1)
        moveHistory.log(0)
        moveHistory.log(1)
        moveHistory.log(0)
        assertThat(moveHistory.getHistorySize()).isEqualTo(5)
    }

    @Test
    fun `자동차의 이동 이력을 정상적으로 출력하는지 체크`() {
        val moveHistory = MoveHistory()
        moveHistory.log(1)
        moveHistory.log(1)
        moveHistory.log(0)
        moveHistory.log(1)
        moveHistory.log(0)
        assertThat(moveHistory.getProgressBar(0)).isEqualTo("-")
        assertThat(moveHistory.getProgressBar(1)).isEqualTo("--")
        assertThat(moveHistory.getProgressBar(2)).isEqualTo("--")
        assertThat(moveHistory.getProgressBar(3)).isEqualTo("---")
        assertThat(moveHistory.getProgressBar(4)).isEqualTo("---")
    }
}
