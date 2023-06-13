package numberBaseBallGame.model;

import java.util.List;
import java.util.stream.Collectors;

public record Numbers(
        List<Integer> numbers
) {
    public int value() {
        String numberString = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
        return Integer.parseInt(numberString);
    }
}