import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public void main(){
        List<Integer> list = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4); // Заполняю элементами список
        // Получение потока
        Stream<Integer> stream = list.stream();
        System.out.println("\r\nРезультат работа с числами - с реализацией \"Stream API\"");
        stream.filter(x -> x>0&& x%2==0).sorted(Comparator.naturalOrder()).forEach(x->System.out.print(x+" "));
    }
}
