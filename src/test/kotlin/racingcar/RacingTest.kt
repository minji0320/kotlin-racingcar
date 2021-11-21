package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.RacingGame
import racingcar.view.ResultView

class RacingTest {
    private val carNames = mutableListOf("a", "b", "c")
    private val racingGame = RacingGame(carNames)
    private val resultView = ResultView()

    @Test
    fun `랜덤 숫자가 0에서 9 사이의 값인지 체크`() {
        assertThat(racingGame.getRandomNum()).isGreaterThanOrEqualTo(RacingGame.MIN_RANDOM_NUMBER)
        assertThat(racingGame.getRandomNum()).isLessThan(RacingGame.UNTIL_RANDOM_NUMBER)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자가 0 ~ 3 사이인 경우 멈춘다`(input: Int) {
        assertThat(racingGame.isMove(input)).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4 ~ 9 사이인 경우 이동한다`(input: Int) {
        assertThat(racingGame.isMove(input)).isTrue
    }

    @Test
    fun `자동차를 정상적으로 초기화하는지 체크`() {
        racingGame.initCars()
        assertThat(racingGame.getCarCount()).isEqualTo(3)

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
        assertThat(resultView.getProgressBar(firstCar)).isEqualTo("a : ----")
    }

    @Test
    fun `자동차 경주의 우승자를 옳게 찾는지 체크`() {
        racingGame.initCars()

        // 자동차 a
        racingGame.cars[0].move(1)
        racingGame.cars[0].move(1)
        racingGame.cars[0].move(1)

        // 자동차 b
        racingGame.cars[1].move(0)
        racingGame.cars[1].move(1)
        racingGame.cars[1].move(1)

        // 자동차 c
        racingGame.cars[2].move(1)
        racingGame.cars[2].move(1)
        racingGame.cars[2].move(1)

        assertThat(racingGame.getWinners()).isEqualTo(mutableListOf("a", "c"))
    }
}
