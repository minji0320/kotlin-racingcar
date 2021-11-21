package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

class InputTest {
    private val inputView = InputView()

    @Test
    fun `형식에 맞지 않게 자동차 이름을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { inputView.validateCarNames("1234567,12345") }
        assertThrows<IllegalArgumentException> { inputView.validateCarNames(" ") }
        assertThrows<IllegalArgumentException> { inputView.validateCarNames(",,,") }
    }

    @Test
    fun `형식에 맞게 자동차 이름을 입력한 경우`() {
        assertThat(inputView.validateCarNames("a,b")).isTrue
        assertThat(inputView.validateCarNames("a,bb,ccc,dddd,eeeee")).isTrue
    }

    @Test
    fun `시도 횟수 입력값이 1 이상이 아닌 경우`() {
        assertThrows<IllegalArgumentException> { inputView.validateTryCount(0) }
        assertThrows<IllegalArgumentException> { inputView.validateTryCount(-1) }
    }

    @Test
    fun `시도 횟수 입력값이 1 이상인 경우`() {
        Assertions.assertDoesNotThrow { inputView.validateTryCount(1) }
        Assertions.assertDoesNotThrow { inputView.validateTryCount(3) }
    }
}
