package apple;

public class HeavyWeightPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return apple.weight() > 150;
    }
}
