import java.util.*;
import java.util.function.*;

public class App {



    public static void main (String[] args) {

     //   firstTask();

     //   secondTask();

     //   thirdTask();

     //   forthTask();

     //   fifthTask();

        sixthTsak();

    }

    private static void sixthTsak() {
        Tree list22 = new Tree(22, null);
        Tree list21 = new Tree(21, null);
        List<Tree> linkedlist2 = new LinkedList<Tree>();
        linkedlist2.add(list21);
        linkedlist2.add(list22);
        Tree list2 = new Tree(2, linkedlist2);
        Tree list12 = new Tree(12, null);
        Tree list11 = new Tree(11, null);
        List<Tree> linkedlist1 = new LinkedList<Tree>();
        linkedlist1.add(list11);
        linkedlist1.add(list12);
        Tree list1 = new Tree(1, linkedlist1);
        List<Tree> linkedlist0 = new LinkedList<Tree>();
        linkedlist0.add(list1);
        linkedlist0.add(list2);
        Tree list0 = new Tree(0, linkedlist0);

        list0.flattened().forEach(i->System.out.print(i.toString()));
        System.out.println();
        list0.getAllValues().forEach(i->System.out.print(i+" "));
        System.out.println();
        System.out.println("Нечетные");
        list0.getEvenOddValues(1).forEach(i->System.out.print(i+" "));
        System.out.println();
        System.out.println("Четные");
        list0.getEvenOddValues(2).forEach(i->System.out.print(i+" "));
        System.out.println();
        System.out.println("Сумма четных");
        System.out.println(list0.sumOfEvenValues());
        System.out.println("Число 13 есть в дереве ?");
        System.out.println(list0.isContains(13));
        System.out.println("Число 2 есть в дереве ?");
        System.out.println(list0.isContains(2));
    }



    private static void fifthTask() {
            // ???
    }

    private static void forthTask() {

        ThreeFunction three = (x,y,z) -> {
            return  (int)x * (int)y * (int)z;
        };
        System.out.println("Multiplication "+ three.apply(2, 3, 4));

        ThreeFunction<Integer,Integer,Integer, Integer> three2 = (x,y,z) ->  x + y + z;
        System.out.println("Summa "+ three2.apply(2, 3, 4));

        ThreeFunction<String,String,String, String> three3 = (x,y,z) ->  x + y + z;
        System.out.println("Concat "+ three3.apply("2", "3", "4"));
    }


    //Определяем функциональный интерфейс
    @FunctionalInterface
    interface MyPredicate {
        boolean test(Integer value);

    }

    private static void thirdTask() {
        //Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
        // Если оно соблюдается, то возвращается значение true. В качестве параметра лямбда-выражение принимает объект типа T:
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println("Predicate "+isPositive.test(5));
        System.out.println("Predicate "+isPositive.test(-5));

        MyPredicate myPredicate = x -> x > 10;
        System.out.println(myPredicate.test(11));

        //BinaryOperator<T> принимает в качестве параметра два объекта типа T,
        // выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T:
        BinaryOperator<Integer> multiply = (x, y) -> x*y;
        System.out.println("BinaryOperator "+multiply.apply(3, 5)); // 15
        System.out.println("BinaryOperator "+multiply.apply(10, -2)); // -20

        //UnaryOperator<T> принимает в качестве параметра объект типа T,
        // выполняет над ними операции и возвращает результат операций в виде объекта типа T:
        UnaryOperator<Integer> square = x -> x*x+x;
        System.out.println("UnaryOperator " + square.apply(5));

        //интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:
        Function<Integer, String> convert = x-> String.valueOf(x) + " string";
        System.out.println(convert.apply(5));
        Function<String, String> concat = x-> x + " of " + x;
        System.out.println(concat.apply("string"));

        // Consumer<T> выполняет действие над объектом типа T,  ничего не возвращая:
        Consumer<Integer> printer = x-> System.out.printf("%d ddddddв", x);
        printer.accept(100500);

        //Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T
        Supplier<Person> personFactory = ()->{
            Scanner in = new Scanner(System.in);
            System.out.println("Input name: ");
            String name = in.nextLine();
            return new Person(name);
        };

        Person baby1 = personFactory.get();
        System.out.println(baby1.toString());
    }


    private static void firstTask() {
        System.out.println("First Lambda Start");
        Runnable task = new Runnable() {
            @Override
            public void run() {
                new RunnableExample().somethingLogic();
                try {
                    System.out.println("We are doing something....");
                    Thread.sleep(1000);
                    System.out.println("We have done....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executeSomething(task);

        Runnable task1 = () -> {
            new RunnableExample().somethingLogic();
            try {
                System.out.println("We are doing something  2 ...");
                Thread.sleep(1000);
                System.out.println("We have done 2....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executeSomething(task1);


        executeSomething(() -> {
            new RunnableExample().somethingLogic();
            try {
                System.out.println("We are doing something lambda 3 ...");
                Thread.sleep(1000);
                System.out.println("We have done 3...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void executeSomething(Runnable mylogic) {
        new Thread(mylogic).start();
    }

    private static void secondTask() {
        System.out.println("Second Lambda Start");
        Collection<Person> persons = new ArrayList<Person>();
        ((ArrayList<Person>) persons).add(new Person("Aled",10));
        ((ArrayList<Person>) persons).add(new Person("Sdrffg",15));
        ((ArrayList<Person>) persons).add(new Person("Dutrr",30));
        ((ArrayList<Person>) persons).add(new Person("Butter",12));

        System.out.println("-- for");
        for( int i=0; i< persons.size(); i++ ) {
            System.out.println(((ArrayList<Person>) persons).get(i).toString() );
        }
        System.out.println("--end--");
        System.out.println("-- foreach");
        for( Person item: persons ) {
            System.out.println(item);
        }
        System.out.println("--end--");

        System.out.println("-- iterable");
        persons.forEach(System.out::println);
        System.out.println("--end--");

        System.out.println("-- lamda");
        persons.forEach(s->System.out.println(s));
        System.out.println("--end--");

        System.out.println("-- stream");
        persons.stream().forEach(s->System.out.println(s));
        System.out.println("--end--");

        System.out.println("-- stream sort by name");
        persons.stream()
                .sorted((p1,p2) -> new PersonNameComparator().compare(p1,p2))
                .forEach(s->System.out.println(s));
        System.out.println("--end--");

        System.out.println("-- stream sort by age");
        persons.stream()
                .sorted((p1,p2) -> new PersonAgeComparator().compare(p1,p2))
                .forEach(s->System.out.println(s));
        System.out.println("--end--");


    }
}
