package calculator

class Calculator {

    fun calculate(input: String?): Int {
        validate(input)

        val numbers = input!!.split(OPERATOR_REGEX).map { it.toInt() }
        val symbols = input.split(NUMBER_REGEX).filter { it.isNotBlank() }

        val operators = mutableListOf<Operator>()
        for (symbol in symbols) {
            operators.add(findOperator(symbol))
        }

        val n = numbers.size
        var result = numbers[0]
        for (i: Int in 1 until n) {
            result = operators[i - 1].operate(result, numbers[i])
        }

        return result
    }

    private fun validate(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 null 또는 빈 공백 문자입니다.")
        } else if (!isFormal(input)) {
            throw IllegalArgumentException("입력값이 올바른 식이 아닙니다. \'숫자 사칙연산(+,-,*,/) 숫자\'의 형식으로 입력해주세요.")
        }
    }

    private fun isFormal(input: String) = input.matches(FORMULA_REGEX)

    private fun findOperator(symbol: String) = Operator.values().find { it.symbol == symbol }!!

    companion object {
        private val FORMULA_REGEX = "\\d+(\\s?[+\\-*/]\\s?\\d+)+".toRegex()
        private val OPERATOR_REGEX = "\\s?[+\\-*/]\\s?".toRegex()
        private val NUMBER_REGEX = "\\s?\\d+\\s?".toRegex()
    }
}
