package java.pl.structures;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    LinkedList list = new LinkedList();

    @Test
    public void should_add_one_element_to_empty_list() {
        // arrange
        String firstElement = "pierwszy";

        // act
        boolean result = list.add(firstElement);

        // assert
        assertEquals(true, result);
    }

    @Test
    public void should_add_many_elements() {
        // arrange
        String firstElement = "pierwszy";
        String secondElement = "second";
        String thirdElement = "third";

        // act
        list.add(firstElement);
        list.add(secondElement);
        list.add(thirdElement);
        // na liście elementy będą w kolejności: "third" -> "second" -> "first" -> NULL

        // assert
        assertEquals(3, list.size());
    }

    @Test
    public void should_return_index_of_present_element() {
        // arrange
        String name = "Jan";
        String surname = "kowalski";
        list.add(name);
        list.add(surname);

        // assert
        // drugi element powinien byc na pozycji 1
        // kolejność: "kowalski" -> "jan" -> NULL
        assertEquals(-1, list.indexOf("not-present-value"));
        assertEquals(0, list.indexOf(surname));
        assertEquals(1, list.indexOf(name));
        assertEquals(2, list.size());
    }

    @Test
    @Disabled
    public void should_add_to_end_of_list() {
        // arrange
        String first = "pierwszy";
        String drugi = "drugi";
        String trzeci = "trzeci";

        // act
        list.add(first);
        list.add(drugi);
        list.add(trzeci);

        // assert
        assertEquals(0, list.indexOf(first));
        assertEquals(1, list.indexOf(drugi));
        assertEquals(2, list.indexOf(trzeci));
        assertEquals(3, list.size());
    }

    @Test
    public void should_remove_first_element() {
        // arrange
        String name = "jan";
        String surname = "kowalski";
        list.add(name);
        list.add(surname);

        // "kowalski" -> "jan"

        // act
        String removedElement = list.removeFirst();

        // assert
        assertEquals(surname, removedElement);
        assertEquals(1, list.size());
    }

    @Test
    public void should_return_null_when_empty_list() {
        // arrange
        // act
        String removedElement = list.removeFirst();

        // assert
        assertEquals(null, removedElement);
        assertEquals(0, list.size());
    }

    @Test
    public void should_remove_last_when_multiple_elements() {
        // arrange
        String name = "jan";
        String surname = "kowalski";
        list.add(name);
        list.add(surname);

        // kowalski -> jan

        // act
        String removedElement = list.removeLast();

        // assert
        assertEquals(name, removedElement);
        assertEquals(false, list.contains(removedElement));
        assertEquals(0, list.indexOf(surname));
    }

    @Test
    public void should_remove_last_when_one_element_on_list() {
        // arrange
        String name = "jan";
        list.add(name);

        // act
        String removedElement = list.removeLast();

        // assert
        assertEquals(name, removedElement);
        assertEquals(false, list.contains(removedElement));
        assertEquals(0, list.size());
    }
}

