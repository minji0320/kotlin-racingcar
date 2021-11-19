package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

class InputTest {
    private val inputView = InputView()

    @Test
    fun `입력값이 1 이상이 아닌 경우`() {
        assertThrows<IllegalArgumentException> { inputView.isValidate(0) }
        assertThrows<IllegalArgumentException> { inputView.isValidate(-1) }
    }

    @Test
    fun `입력값이 1 이상인 경우`() {
        Assertions.assertDoesNotThrow { inputView.isValidate(1) }
        Assertions.assertDoesNotThrow { inputView.isValidate(3) }
    }
}
