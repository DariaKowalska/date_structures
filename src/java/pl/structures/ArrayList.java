package java.pl.structures;

import java.util.Arrays;

public class ArrayList implements MyList{
    private static int DEFAULT_CAPACITY = 10;
    // tablica z elementami - w tej implementacji chcemy "opakowac" tablicę tak by wygladala jak lista
    private String[] elements;
    // zmienna przechowujaca informacje o pozycji na którą wstawić element
    // wskaźnik na pierwsze wolne miejsce
    // pierwszym wolnym miejscem w tablicy jest index 0
    private int index = 0;

    public ArrayList() {
        // konstruktor bezparamterowy utowrzy listę z początkową wielkością 10
        this.elements = new String[DEFAULT_CAPACITY];
    }

    // drugi konstruktor z opcją ustawienia startowej wielkości listy
    // efektywne rozwiązanie, gdy znamy liczbe elementow z gory
    public ArrayList(int initialSize) {
        // korzystamy z argumentu konstruktora, a nie ze stałej DEFAULT_CAPACITY
        this.elements = new String[initialSize];
    }

    @Override
    public boolean add(String element) {
        // na jaka pozycje wstawić? na pozycje index
        // zwieksz index o 1
        // obsluga sytuacji, gdzie tablica jest pełna
        // jesli tablica jest pelna to chcemy skopiować obecną tablicę do nowej - 2 razy większej
        // funkcja Arrays.copyOf()

        // rozpoczynamy od sprawdzenia, czy mozemy wstawic do tablicy
        // jeśli index == elements.length -> to znaczy, ze tablica elements jest pełna
        // czyli próba wstawienia czegos do pełnej tablicy zakończy się błędem
        // ArrayIndexOutOfBoundException
        if (index == elements.length) {
            // tablica pełna! robimy kopiowanie
            // starą tablicę elements zastępujemy nową 2x większą
            // Pierwszy parametr funkcji copyOf to tablica z której będziemy kopiować,
            // drugi parametr to rozmiar nowej tablicy
            // typ zwracany to nowa tablica;
            // wynik działania tej funkcji przypisujemy do zmiennej elements
            // -> elements powiększamy dwa razy
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        // w tym miejscu mamy pewność, ze mamy gdzie wstawic element (bo jeśli tablica była pełna to już
        // jest powiększona)
        // wstawiamy element do tablicy
        elements[index] = element;
        // zwiększamy index
        index++;
        return true;
    }

    @Override
    public boolean remove(String element) {
        // todo: wykorzystaj istniejące metody do usuwanie elementu
        return false;
    }

    @Override
    public String remove(int position) {
        // sprawdź zakres position >=0 && position < this.index
        // jeśli zakres jest nieprawidłowy - za mały lub za duży to rzuć wyjątkiem
        // IndexOutOfBoundsException
        // usunąć element i lukę którą pozostawi, jesli jest środkowym bądź pierwszym elementem
        if (position < 0 || position >= index) {
            throw new IndexOutOfBoundsException("Wrong index parameter");
        }
        // pobieramy element, ktory ma zostac usuniety, aby go potem zwrócić
        String elementToRemove = elements[position];
        index--;
        // kopiujemy pozostałą prawą część tablicy, tak aby pozbyc się luki w środku tablicy
        for (int i = position; i < index; i++) {
            elements[i] = elements[i + 1];
        }

        // przesunęliśmy index o 1 pozycję w lewo i skopiowaliśmy pozostałe elementy
        // jednak ostatnia "prawa" wartość została zduplikowana, u nas z tablicy [a, b, c]
        // po usunięciu b, zostanie [a, c, c] - mamy 2 razy c, mimo, iż wstawiliśmy tylko 1 raz
        // gdybyśmy kasowali kolejny element, to nagle mamy duplikat i niespojność
        // w celu uniknięcia duplikatu, na pozycję index wpisujemy null
        //
        elements[index] = null;
        return elementToRemove;
    }

    @Override
    public String removeFirst() {
        // todo: wykorzystaj istniejące metody do usuwanie elementu
        return null;
    }

    @Override
    public String removeLast() {
        // usuwamy ostatni element z tablicy
        // O(1)
        // zwróć uwagę na usuwanie z pustej listy
        if (isEmpty()) {
            return null;
        }
        String toRemove = elements[index - 1];
        elements[index - 1] = null;
        index--;
        return toRemove;
    }

    @Override
    public boolean isEmpty() {
        // sprawdza, czy lista jest pusta
        // lista jest pusta, gdy index wskazuje na zerowy element
        // oblicz wartość wyrażenia czy index jest równy 0 i zwróc je
        return index == 0;

        // to samo co wyzej - 1 linia
        // return index == 0;
    }

    @Override
    public int indexOf(String element) {
        // zwróć indeks elementu jeśli występuje, bądź -1 jeśli go nie ma
        // i < index, ponieważ nie chcemy szukać w pustych elementach, bo skończy się no
        // NullPointerException
        for (int i = 0; i < index; i++) {
            if (elements[i].equals(element)) {
                // jeśli true to znaleźliśmy szukany element
                // od razu zwracamy wynik
                return i;
            }
        }
        // jeśli nic nie zlaleziono, to zwrocimy -1
        // rowniez jesli lista będzie pusta to tez zwrocimy -1 (petla for ani razu sie nie wykona)
        return -1;
    }

    @Override
    public boolean contains(String element) {
        // zwróc czy prawdą jest, ze indexOf(element) >= 0
        return indexOf(element) >= 0;
        //    bardziej rozbudowana wersja - preferujemy tą krótszą ;)
        //    if (indexOf(element) >= 0) {
        //      return true;
        //    }
        //    return false;
    }

    @Override
    public void clear() {
        // tworzymy nową tablicę o takim samym rozmiarze
        this.elements = new String[elements.length];
        // zerujemy indeks
        this.index = 0;
    }

    @Override
    public int size() {
        return index;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i = 0; i < index; i++) {
            builder.append(elements[i]);
            if (i != index - 1) {
                builder.append(", ");
            }
        }
        builder.append(" ]");
        return builder.toString();
    }
}
