package java.pl.structures;

public interface MyList {
    // operacja dodawania elementu typu String do listy
    boolean add(String element);

    // operacja usuwania elementu po nazwie ("usuń Kowalskiego z listy");
    // będziemy najpierw musieli tego Kowalskiego znaleźć :)
    boolean remove(String element);

    // operacja usuwania po pozycji ("usuń trzeci element")
    String remove(int index);

    String removeFirst();

    String removeLast();

    // odpowiada na pytanie, czy lista pusta
    boolean isEmpty();

    // zwraca pozycje szukanego elmentu
    // jeśli elementu nie ma na liście to zwracamy -1
    int indexOf(String element);

    // odpowiada na pytanie, czy element obecny na liście
    boolean contains(String element);

    // usuwa wszystkie elementy z listy
    void clear();

    // zwraca rozmiar listy
    int size();
}
