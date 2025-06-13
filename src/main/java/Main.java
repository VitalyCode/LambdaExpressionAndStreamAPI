import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //=====================Task № 1
        Calculate calculate = new Calculate();
        int a = calculate.plus.apply(1, 2);
        int b = calculate.minus.apply(1, 1);
        try {
            if (b != 0) {
                int c = calculate.devide.apply(a, b);
            } else {
                throw new ArithmeticException("Делить на ноль нельзя");
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
        int g = calculate.multiply.apply(a, b);
        System.out.println("\r\n");
        //=====================Task № 2
        OnTaskDoneListener listener = result -> System.out.println(result); // лямбд выражение,можно конечно же вот так: System.out::println;
        Worker worker = new Worker(listener);
        worker.start();
        System.out.println("\r\n");

        //=====================Task 3: Working with numbers
        NoStreamMain noStreamMain = new NoStreamMain();
        noStreamMain.main();

        //=====================Task 3: Working with numbers
        StreamMain streamMain = new StreamMain();
        streamMain.main();

        //=====================Task 4: Population census
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        // Подсчет несовершеннолетних:
        long countMinors = persons.stream().filter(x->x.getAge()<17).count();
        System.out.println("\r\nКоличество несоверненнолетних: "+countMinors);

        // Получить список фамилии призывников(т.е мужчин от 18 до 27 лет)
        List<String> conscripts = persons.stream().filter(person->person.getSex()==Sex.WOMAN&&person.getAge()>=18&&person.getAge()<=27)
                .map(Person::getFamily).
                collect(Collectors.toList());
        System.out.println("\r\nСписок фамилий призывников:");
        conscripts.stream().forEach(System.out::println);

        // Отсортированный список трудоспособных людей с высшим образованием
        List<Person> ableBodiedPeopleWithHigherEducation = persons.stream().filter(person -> person.getEducation()==Education.HIGHER
                &&person.getSex()==Sex.WOMAN
                &&person.getAge()>=18
                &&person.getAge()<=60|| person.getSex()==Sex.MAN&&person.getAge()>=18&&person.getAge()<=65)
                .sorted(Comparator.comparing(Person::getFamily)).collect(Collectors.toList());
        System.out.println("\nОтсортированный список трудоспособных людей с высшим образованием:");
        ableBodiedPeopleWithHigherEducation.forEach(System.out::println);

    }
}

// Пол
enum Sex {
    MAN, // Мужчины
    WOMAN // Женщины
}

// Типы образования
enum Education {
    ELEMENTARY, // Начальный
    SECONDARY, // Средний
    FURTHER, // Дальнейший
    HIGHER // Высший
}

class Person {
    private String name; // Имя
    private String family; // Фамилия
    private Integer age; // Возраст
    private Sex sex; // Пол
    private Education education; // Образование

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    // Свойство для чтения имени:
    public String getName() {
        return name;
    }

    // Свойство для чтения фамилии:
    public String getFamily() {
        return family;
    }

    // Свойство для чтения возвраста:
    public Integer getAge() {
        return age;
    }

    // Свойство для чтения пола:
    public Education getEducation() {
        return education;
    }
    public Sex getSex(){
        return sex;
    }

    // Переопределеныый toString - для вывода информации о человеке
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}
