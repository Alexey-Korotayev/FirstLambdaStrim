import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {

        if (person1.getAge() > person2.getAge())
            return 1;
        else if (person1.getAge() < person2.getAge())
            return -1;
        else
            return 0;

    }
}
