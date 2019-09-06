package tests;


import org.junit.Assert;
import org.junit.Test;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class IntegerStreamUsage {

    @Test
    public void createAndPrintIntegerStream(){
        final IntStream intStream = IntStream.of(2, 6, 3, 1, 7, 5, 7);
        intStream.forEach(System.out::print);
    }

    @Test
    public void range_exclusiveVersion(){
        final IntStream intStream = IntStream.range(1,100);
        Assert.assertEquals(intStream.count(),99);
    }

    @Test
    public void rangeClosed_inclusiveVersion(){
        final IntStream intStream = IntStream.rangeClosed(1,100);
        Assert.assertEquals(intStream.count(),100);

    }

    @Test
    public void iterateAndLimit(){
        final IntStream intStream = IntStream.iterate(0,operand -> operand + 2).limit(20);
        Assert.assertEquals(380,intStream.sum());

    }

    @Test
    public void printEvenNumbers_from1To100(){
        IntStream.iterate(1,operand -> operand + 1)
                .filter(num -> num % 2 == 0)
                .limit(50).forEach(System.out::println);
    }

    @Test
    public void findMinNumber(){
        final int min = IntStream.of(5, 6, 3, 9, 10).min().getAsInt();
        Assert.assertEquals(3,min);
    }

    @Test
    public void findMaxNumber(){
        final int max = IntStream.of(5, 6, 3, 9, 10,8).max().getAsInt();
        Assert.assertEquals(10,max);
    }

    @Test
    public void findDistinctNumbers(){
        final IntStream intStream = IntStream.of(5, 6, 3, 9, 10, 8, 5, 6, 3, 9, 10, 8, 22, 28, 11).distinct().map(IntUnaryOperator.identity());
        Assert.assertArrayEquals( new int[] {5, 6, 3, 9, 10, 8, 22, 28, 11},intStream.toArray());
    }

    @Test
    public void findSumOfNumber(){
        final int sum = IntStream.of(1,2,3,4,5).sum();
        Assert.assertEquals( 15, sum);
    }

    @Test
    public void findAverageOfNumbers(){
        final double average = IntStream.of(1, 2, 3, 4, 5).average().orElse(0);
        Assert.assertEquals( 3.0d, average,0);
    }

}
