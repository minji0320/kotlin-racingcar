package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.RacingGame

class RacingTest {
    private val carNames = mutableListOf("a", "b", "c", "d", "e")
    private val racingGame = RacingGame(carNames, 5)

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
    fun `자동차를 정상적으로 초기화하는지 체크`() {
        racingGame.initCars()
        assertThat(racingGame.getCarCount()).isEqualTo(5)

        for (i in 0 until racingGame.getCarCount()) {
            assertThat(carNames[i]).isEqualTo(racingGame.cars[i].name)
        }
    }

    @Test
    fun `자동차의 이름과 현재 위치를 정상적으로 출력하는지 체크`() {
        racingGame.initCars()
        val firstCar = racingGame.cars[0] // "자동차 a"
        firstCar.move(1)
        firstCar.move(1)
        firstCar.move(1)
        firstCar.move(0)
        firstCar.move(1)
        assertThat(firstCar.getProgressBar()).isEqualTo("a : ----")
    }
}
