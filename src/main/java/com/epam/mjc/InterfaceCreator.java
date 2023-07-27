package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean result = true;

            for (String str : x) {
                char firstLetter = str.charAt(0);
                if (!Character.isUpperCase(firstLetter)) {
                    result = false;
                    break;
                }
            }
            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> numbersToAdd = new ArrayList<>();

            for (Integer number : x) {
                if (number % 2 == 0) numbersToAdd.add(number);
            }
            x.addAll(numbersToAdd);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();

            for (String str : values) {
                if (Character.isUpperCase(str.charAt(0)) && str.endsWith(".") && str.split(" ").length > 3)
                    result.add(str);
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();

            for (String str : x) {
                result.put(str, str.length());
            }
            return result;

        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();

            result.addAll(list1);
            result.addAll(list2);

            return result;
        };
    }
}
