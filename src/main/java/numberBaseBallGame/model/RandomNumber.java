package numberBaseBallGame.model;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@FunctionalInterface
public interface RandomNumber {
    Numbers generator(int size);

    RandomNumber AUTO = (int SIZE) -> new Numbers(new Random().ints(0, 10)
            .distinct()
            .limit(3)
            .boxed()
            .toList());

    RandomNumber INPUT = (int SIZE) -> {
        try {
            String input = new Scanner(System.in).nextLine();
            return new Numbers(
                    Arrays.stream(input.split(""))
                            .mapToInt(Integer::valueOf)
                            .boxed()
                            .toList()
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이 입력은 빈문자열을 입력할 수 없습니다. 다시 입력해주세요.");
        }
    };
}
