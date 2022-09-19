import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("1 - Find out sum of all numbers between 1 and 10000 that are dividable by both 3 and 5 but not dividable by 7.");

        Stream<Integer> numbers1 = Stream
                .iterate(1, A -> A + 1)
                .limit(10000)
                .filter(A -> (A % 3 == 0 && A % 5 == 0 && A % 7 != 0));

        int sum = numbers1
                .mapToInt(A -> A)
                .sum();

        System.out.println(sum);
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("2 - Print first 100 even numbers that are not dividable by 8");

        List<Integer> numbers2 = Stream
                .iterate(1, A -> A + 1)
                .filter(A -> ((A % 2 == 0) && (A % 8 != 0)))
                .limit(100)
                .collect(Collectors.toList());

        System.out.println(numbers2);
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("3.1 - Print names (in alphabetic order) of all books that have price smaller than 100.");

        Stream <Book> list1 = list();

        list1
                .sorted(Comparator.comparing(Book::getName))
                .filter(A -> A.getPrice() < 100)
                .forEach(A -> System.out.println(A.getName()));
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("3.2 - Find out how many books have name shorter than 5 characters.");

        Stream <Book> list2 = list();

        int numberOfBooks = (int)list2
                .filter(A -> A.getName().length() < 5)
                .count();

        System.out.println(numberOfBooks);
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("3.3 - Find out what is the average price of the book in the list");

        Stream <Book> list3 = list();

        double sumOfBooks = list3
                .collect(Collectors.averagingDouble(A -> A.getPrice()));

        System.out.println(sumOfBooks);
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("3.4 - Find out if all books in list are cheaper than 500");

        Stream <Book> list4 = list();

        boolean isCheaper = list4
                .allMatch(A -> A.getPrice() < 500);

        System.out.println(isCheaper);
//----------------------------------------------------------------------------------------------------------------------
    }
    public static Stream<Book> list() {
        return
                Stream.of
                        (
                                new Book("Game of Thrones", 123),
                                new Book("The House of Dragon", 125),
                                new Book("Inferno", 90),
                                new Book("Atlantis", 85),
                                new Book("Ready Player One", 99),
                                new Book("It", 130)
                        );
    }
}