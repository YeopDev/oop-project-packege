package apple;

public class GreenColorPredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "Green".equals(apple.color());
    }
}
