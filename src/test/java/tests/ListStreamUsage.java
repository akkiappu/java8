package tests;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListStreamUsage {
    @Test
    public void minNumberFromList() {
        final int min = ImmutableList.of(2, 6, 3, 1, 7).stream().min(Comparator.naturalOrder()).orElse(-1);
        Assert.assertEquals(1, min);
    }

    @Test
    public void maxNumberFromList() {
        final int max = ImmutableList.of(2, 6, 3, 1, 7).stream().max(Comparator.naturalOrder()).orElse(-1);
        Assert.assertEquals(7, max);
    }

    /***
     * Below method can also be use for removing duplicate from list
     */
    @Test
    public void distinctNumbersFromList_usingToArray() {
        final Integer[] distinctNumArray = ImmutableList.of(2, 6, 3, 1, 7, 2, 6, 3, 1, 7, 3, 5, 10).stream().distinct().toArray(Integer[]::new);
        Assert.assertArrayEquals(new Integer[]{2, 6, 3, 1, 7, 5, 10}, distinctNumArray);
    }

    /***
     * Below method can also be use for removing duplicate from list
     */
    @Test
    public void distinctNumbersFromList_usingCollectToList() {
        final List<Integer> distinctNumList = ImmutableList.of(2, 6, 3, 1, 7, 2, 6, 3, 1, 7, 3, 5, 10).stream().distinct().collect(Collectors.toList());
        Assert.assertEquals(ImmutableList.of(2, 6, 3, 1, 7, 5, 10), distinctNumList);
    }

    @Test
    public void collectSetFromList() {
        final Set<Integer> integerSet = ImmutableList.of(2, 6, 3, 1, 7, 2, 6, 3, 1, 7, 3, 5, 10)
                .stream()
                .collect(Collectors.toSet());
        Assert.assertEquals(ImmutableSet.of(2, 6, 3, 1, 7, 5, 10), integerSet);
    }


    @Test
    public void filterEvenNumbersFromList() {
        final List<Integer> evenNumbers = ImmutableList.of(2, 6, 3, 1, 7, 2, 6, 3, 1, 7, 3, 5, 10)
                .stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        Assert.assertEquals(ImmutableList.of(2, 6, 2, 6, 10), evenNumbers);
    }

    @Test
    public void numbersRepetitiveCount() {
        final Map<Integer, Long> repetitiveCount = ImmutableList.of(2, 6, 3, 1, 7, 2, 6, 3, 1, 7, 3, 5, 10)
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(repetitiveCount);
    }
}
