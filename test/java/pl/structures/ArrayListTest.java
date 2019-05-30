package java.pl.structures;

import org.junit.Test;

import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {
    private ArrayList lista = new ArrayList(5);

    @Test
    public void should_add_new_element_to_empty_list() {
        // AAA
        // arrange
        String firstElement = "pierwszy";
        // act
        boolean result = lista.add(firstElement);

        // assert
        // w tym kroku programistycznie wymuszamy warunek powodzenia testu
        // jeśli ta asercja jest prawdziwa to test zakończy się powodzniem
        // oczekujemy, ze
        // dodawanie sie powiodlo
        assertEquals(result, true);
        // jesli sie powiodlo, to contains powinno zwrocic true
        assertEquals(lista.contains(firstElement), true);
        // a index dodanego elementu to 0
        assertEquals(lista.indexOf(firstElement), 0);
    }

    @Test
    public void should_increase_capacity() {
        // arrange
        // tworzymy liste 2 elementową
        lista = new ArrayList(2);
        String firstElement = "first";
        String secondElement = "second";
        String thirdElement = "third";

        // act
        // dodajemy 3 elementy
        lista.add(firstElement);
        lista.add(secondElement);
        lista.add(thirdElement);

        // assert
        // lista powinna miec wszystkie elmenty dodane
        assertEquals(lista.contains(firstElement), true);
        assertEquals(lista.contains(secondElement), true);
        assertEquals(lista.contains(thirdElement), true);
    }

    @Test
    public void should_return_index_of_element() {
        // arrange
        String firstElement = "pierwszy";
        String nonPresentElement = "drugi";

        // act
        // jeden element wstawiamy
        // drugi nie wstawiamy
        lista.add(firstElement);

        // assert
        // lista powinna zawierac 1 element
        // a nonPresentElement powinien mieć index -1
        assertEquals(lista.indexOf(firstElement), 0);
        assertEquals(lista.indexOf(nonPresentElement), -1);
    }

    @Test
    public void should_return_zero_when_empty_list() {
        // arrange
        // act
        int size = lista.size();
        // assert
        assertEquals(size, 0);
    }

    @Test
    public void should_return_list_size() {
        // arrange
        String element = "first";

        // act
        lista.add(element);

        // assert
        assertEquals(lista.size(), 1);
    }

    @Test
    public void should_clear_list() {
        // arrange
        String element = "testowy-element";
        lista.add(element);
        // act
        lista.clear();
        // assert
        assertEquals(0, lista.size());
    }

    @Test
    public void should_remove_last_element() {
        // arrange
        String firstElement = "pierwszy";
        String secondElement = "drugi";
        String thirdElement = "trzeci";
        lista.add(firstElement);
        lista.add(secondElement);
        lista.add(thirdElement);

        // act
        String removedElement = lista.removeLast();

        // assert
        // oczekujemy, ze prawdą jest, ze na liście nie ma usuniętego elementu
        assertEquals(false, lista.contains(removedElement));
        assertEquals(2, lista.size());
        assertEquals(true, lista.contains(firstElement));
        assertEquals(true, lista.contains(secondElement));
    }

    @Test
    public void should_return_null_when_removing_from_empty_list() {
        // arrange
        // act
        String removedElement = lista.removeLast();
        // assert
        assertEquals(null, removedElement);
    }

    @Test
    public void should_remove_by_position() {
        // arrange
        String first = "a";
        String second = "b";
        String third = "c";
        lista.add(first);
        lista.add(second);
        lista.add(third);

        // act
        String removedElement = lista.remove(1);

        // assert
        // oczekiwany rozmiar to 2
        assertEquals(2, lista.size());
        // lista nie powinna zawierać usuniętego elementu
        assertEquals(false, lista.contains(removedElement));
        // pozycja elementu "third = c" powinna być na pozycji 1 (czyli zostać przesunięta w lewo)
        assertEquals(1, lista.indexOf(third));
    }

    @Test
    public void should_throw_exception_when_illegal_index_passed() {
        // chcemy, zeby test byl na zielono, tylko jesli wyjątek zostanie rzucony
        int illegalArgument = -2;

        Executable obiektAnonimowejKlasy =
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        lista.remove(illegalArgument);
                    }
                };
        assertThrows(IndexOutOfBoundsException.class, obiektAnonimowejKlasy);
    }

    // ten kod mozemy zastąpić klasą anonimową
    //  static class IllegalArugumentExecutable implements Executable {
    //
    //    private MyList myList;
    //    private int illegalArgument;
    //
    //    IllegalArugumentExecutable(MyList myList, int illegalArgument) {
    //      this.myList = myList;
    //      this.illegalArgument = illegalArgument;
    //    }
    //
    //    @Override
    //    public void execute() throws Throwable {
    //      myList.remove(illegalArgument);
    //    }
    //  }
}