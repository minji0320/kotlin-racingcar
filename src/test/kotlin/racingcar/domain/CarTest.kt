package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarTest {

    @ParameterizedTest(name = "{0}일 경우")
    @MethodSource("overFour")
    fun `이동 4보다 크거나 같을 때`(value: Number) {
        val car = Car(Name("test"))
        val movedCar = car.move(value)
        assertThat(car.distance).isNotEqualTo(movedCar.distance)
    }

    @ParameterizedTest(name = "{0}일 경우")
    @MethodSource("underFour")
    fun `이동 숫자가 4보다 작을 때`(value: Number) {
        val car = Car(Name("test"))
        val movedCar = car.move(value)
        assertThat(car.distance).isEqualTo(movedCar.distance)
    }

    @Test
    fun `같은 거리인지 체크 같은 거리일 경우`() {
        val car = Car(Name("test"))

        assertThat(car.isSameDistance(Distance(0))).isTrue()
    }

    @Test
    fun `같은 거리인지 체크 다른 거리일 경우`() {
        val car = Car(Name("test"))
        val movedCar = car.move(Number(4))

        assertThat(car.isSameDistance(Distance(2))).isFalse()
    }

    companion object {
        @JvmStatic
        fun overFour(): Stream<Number> {
            return Stream.of(
                Number(4),
                Number(5),
                Number(6),
                Number(7),
                Number(8),
                Number(9)
            )
        }

        @JvmStatic
        fun underFour(): Stream<Number> {
            return Stream.of(
                Number(0),
                Number(1),
                Number(2),
                Number(3)
            )
        }
    }
}
