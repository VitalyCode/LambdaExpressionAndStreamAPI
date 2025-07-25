import java.util.function.*;

public class Calculate {
    public static Supplier<Calculate> instance = Calculate::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;

    BinaryOperator<Integer> minus = (x, y) -> x - y;

    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    BinaryOperator<Integer> devide = (x, y) -> x / y;

    UnaryOperator<Integer> pow = x -> x * x;

    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
