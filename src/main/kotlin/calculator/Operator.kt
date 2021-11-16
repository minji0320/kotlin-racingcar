package calculator

enum class Operator(
    val symbol: String,
    val operate: (left: Int, right: Int) -> Int
) {
    ADDITION("+", { left, right -> left + right }),
    SUBTRACTION("-", { left, right -> left - right }),
    MULTIPLICATION("*", { left, right -> left * right }),
    DIVISION(
        "/",
        { left, right ->
            require(right != 0)
            left / right
        }
    );

    fun apply(left: Int, right: Int): Int {
        return operate(left, right)
    }
}
