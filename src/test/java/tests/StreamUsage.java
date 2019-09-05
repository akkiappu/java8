package tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamUsage {

    @Test
    public void findAverageOfNumbers(){
        final int average = Stream.of(1, 2, 3, 4, 5).min(Comparator.naturalOrder()).orElse(0);
        Assert.assertEquals( 1,average);
    }
}
