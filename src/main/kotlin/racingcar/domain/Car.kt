package racingcar.domain

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move(distance: Int) {
        position += distance
    }

    fun getProgressBar(): String {
        return "$name : " + "-".repeat(position)
    }
}
