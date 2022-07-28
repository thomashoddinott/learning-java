package com.newthinktank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Foo {
    public static void main(String[] args) {
        ArrayList<Integer> oneTo5 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        // oneTo5.forEach(x -> System.out.println(x*2));
        // oneTo5.forEach(x -> { if (x%2 == 0) System.out.println(x);});

        List<Integer> fib = new LinkedList<Integer>();

        fib = Stream.iterate(
            new int[]{0, 1},
            t -> new int[]{t[1], t[0] + t[1]})
            .limit(10)
            .map(n -> n[0])
            .collect(Collectors.toList());
        fib.forEach(x -> System.out.println(x));
    }
}
