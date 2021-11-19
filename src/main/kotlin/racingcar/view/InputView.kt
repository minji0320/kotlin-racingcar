package racingcar.view

private val READ_LINE_NULL_EXCEPTION = IllegalArgumentException("입력값으로 null을 허용하지 않습니다.")
private val INPUT_VALIDATION_ERROR = IllegalArgumentException("입력값은 1 이상이어야 합니다.")

class InputView {
    fun askCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()?.toInt() ?: throw READ_LINE_NULL_EXCEPTION
        return isValidate(carCount)
    }

    fun askTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()?.toInt() ?: throw READ_LINE_NULL_EXCEPTION
        return isValidate(tryCount)
    }

    fun isValidate(input: Int): Int {
        if (input <= 0)
            throw INPUT_VALIDATION_ERROR
        return input
    }
}
