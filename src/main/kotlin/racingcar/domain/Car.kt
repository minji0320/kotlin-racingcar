package racingcar.domain

class Car(val name: String) {
    var position: Int = INIT_POSITION
        private set

    fun move(distance: Int) {
        position += distance
    }

    companion object {
        const val INIT_POSITION = 0
    }
}
