import java.util.stream.IntStream;

public class IterateStream {
    public static void main(String[] args) {
        IntStream.range(0,100)
                .filter(even -> even % 2 ==0)
                .limit(10)
                .forEach(System.out::println);
    }
}
