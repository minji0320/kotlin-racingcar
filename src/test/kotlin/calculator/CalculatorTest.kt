package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `덧셈`() {
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        assertThat(calculator.calculate("4 - 3")).isEqualTo(1)
    }

    @Test
    fun `곱셈`() {
        assertThat(calculator.calculate("5 * 6")).isEqualTo(30)
    }

    @Test
    fun `나눗셈`() {
        assertThat(calculator.calculate("7 / 7")).isEqualTo(1)
    }

    @Test
    fun `0으로 나누는 경우`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("8 / 0") }
    }

    @Test
    fun `계산을 여러번 하는 경우`() {
        assertThat(calculator.calculate("9 / 3 + 10")).isEqualTo(13)
    }

    @Test
    fun `입력값이 null 또는 빈 공백 문자인 경우`() {
        assertThatThrownBy {
            calculator.calculate(" ")
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("1 + 2 $") }
        assertThrows<IllegalArgumentException> { calculator.calculate("1 ! 2") }
        assertThrows<IllegalArgumentException> { calculator.calculate("@") }
    }

    @Test
    fun `계산식이 유효하지 않는 경우`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("1 + + 21 + 2 /") }
        assertThrows<IllegalArgumentException> { calculator.calculate("0 + 2 + 2 / / 1") }
        assertThrows<IllegalArgumentException> { calculator.calculate("") }
    }
}
