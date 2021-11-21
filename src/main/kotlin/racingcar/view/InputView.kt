package racingcar.view

private val READ_LINE_NULL_EXCEPTION = IllegalArgumentException("입력값으로 null을 허용하지 않습니다.")
private val CAR_NAMES_VALIDATION_ERROR =
    IllegalArgumentException("자동차 이름은 1 ~ 5자로 입력해야 하며, \'이름1,이름2\'와 같은 형식으로 입력해야 합니다.")
private val TRY_COUNT_VALIDATION_ERROR = IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
private val CAR_NAMES_REGEX = "\\w{1,5}(,\\w{1,5})+".toRegex()

class InputView {
    fun readCarNames(): MutableList<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val stringNames = readLine() ?: throw READ_LINE_NULL_EXCEPTION

        validateCarNames(stringNames)
        return convertStringNamesToList(stringNames)
    }

    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()?.toInt() ?: throw READ_LINE_NULL_EXCEPTION
        return validateTryCount(tryCount)
    }

    fun validateCarNames(input: String): Boolean {
        if (!input.matches(CAR_NAMES_REGEX))
            throw CAR_NAMES_VALIDATION_ERROR
        return true
    }

    fun validateTryCount(input: Int): Int {
        if (input <= 0)
            throw TRY_COUNT_VALIDATION_ERROR
        return input
    }

    fun convertStringNamesToList(stringNames: String): MutableList<String> {
        val carNames = mutableListOf<String>()
        stringNames.split(",").forEach {
            carNames.add(it)
        }
        return carNames
    }
}
