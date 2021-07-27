package colls;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DemoCollections {

    private int x;
    private int g;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoCollections that = (DemoCollections) o;
        return x == that.x && g == that.g;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, g);
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("anil", "1"));
        persons.add(new Person("colls", "2"));

    }
    public static void sample(List<Integer> li) {

    }

}
