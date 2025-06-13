import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class NoStreamMain {
    public void main(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4)); // Заполняю элементами список

        // Филтрация положительных чисел в списке:
        List<Integer> positiveNumbersList = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            if(list.get(i)>0&&list.get(i)%2==0){ // условия больше 0 и остаток 0
                positiveNumbersList.add(list.get(i)); // Добавление элементов в новый список
            }
        }

        // Сортировка нового списка:
        positiveNumbersList.sort(Integer::compare);
        List<Integer> sortList = new ArrayList<>(); // Создаю новый список для отсортированных элементов

        for(int i = 0;i<positiveNumbersList.size();i++){
            sortList.add(positiveNumbersList.get(i));
        }

        // Вывод:
        System.out.println("Результат работы с числами - без реализации: \"Stream API\"");
        for(int i = 0;i<sortList.size();i++){
            System.out.print(sortList.get(i)+" ");
        }
    }
}
