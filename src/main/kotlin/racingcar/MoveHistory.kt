package racingcar

class MoveHistory() {
    private val history = mutableListOf<Int>()

    fun log(distance: Int) {
        if (history.isEmpty()) {
            history.add(distance)
        } else {
            history.add(history.last() + distance)
        }
    }

    fun getProgressBar(idx: Int): String {
        return "-".repeat(history[idx])
    }

    fun getHistorySize() = history.size
}
