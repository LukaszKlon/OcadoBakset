# OcadoBakset
Rozwiązanie zadania składa się z czterech klas:

  BasketSplitter, główna funkcja programu (o najwyższym poziomie abstrakcji). Aby unikać kilkukrotnego wczytywania danych dotyczących możliwych dostaw wczytujemy je podczas inicjalizacji klasy. Metoda split otrzymuje produkty, które trzeba dostarczyć zwraca mapę mówiącą o sposobie dostawy.
  
  JsonLoader obsługuje ona wczytywanie plików Json.
  
  GreedyAlgorithm klasa ta odpowiada za logikę obsługi algorytmu, który zostanie opisany poniżej.
  
  PrepareSets klasa składa się z dwóch metod. Pierwsza mapReverse odwraca mapę na klucz - sposób dostawy, wartość - produkty, które można dostarczyć w ten sposób


Algorytm:
Problem możemy utożsamić z problemem pokrycia zbioru (cover set problem) jest to problem NP-trudny. Dlatego zastosowaliśmy algorytm zachłanny, który dobrze radzi sobie z tym problemem. Lista kroków algorytmu:
Wykonuj kroki od 2 do 4 dopóki zbiór produktów nie jest pusty
Spośród wszystkich metod dostawy wybierz tą, która ma największą część wspólną
Dodaj część wspólną do rozwiązania 
Odejmij część wspólną ze zbioru produktów
Zwróć sposoby dostawy wraz z odpowiadającymi im produktami

Aby uniknąć zbyt dużej ilości iteracji rozważamy tylko metody dostawy, które są dostępne dla naszego koszyka.

Ścieżki do testów zawierają ścieżki bezwzględne.  

Autor: Łukasz Klon

