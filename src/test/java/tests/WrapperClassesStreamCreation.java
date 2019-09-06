package tests;

import org.junit.Test;

import java.util.stream.Stream;

public class WrapperClassesStreamCreation {

    @Test
    public void integers(){
        Stream.of(1,3,5,7,9).forEach(System.out::print);
    }

    @Test
    public void longs(){
        Stream.of(1L,3L,5L,7L,9L).forEach(System.out::print);
    }

    @Test
    public void characters(){
        Stream.of('a','b','c','d','e').forEach(System.out::print);
    }

    @Test
    public void strings(){
        Stream.of("Java","Kafka","Stream").forEach(System.out::print);
    }

    @Test
    public void floats(){
        Stream.of(1f,3f,5f,7f,9f).forEach(System.out::print);
    }

    @Test
    public void doubles(){
        Stream.of(1d,3d,5d,7d,9d).forEach(System.out::print);
    }
}
