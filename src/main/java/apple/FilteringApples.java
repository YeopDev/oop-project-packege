package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "Green"),
                new Apple(155, "Green"),
                new Apple(120, "Red")
        );

        List<Apple> heavyApples = filter(inventory, (Apple apple) -> apple.weight() > 150);
        List<Apple> greenApples = filter(inventory, (Apple apple) -> "Red".equals(apple.color()));
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}
