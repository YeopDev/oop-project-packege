package numberBaseBallGame;

import numberBaseBallGame.model.GameRule;
import numberBaseBallGame.model.Match;
import numberBaseBallGame.model.RandomNumber;

public class Starter {
    static RandomNumber auto = RandomNumber.AUTO;
    static RandomNumber input = RandomNumber.INPUT;
    static GameRule basic = GameRule.BASIC;
    static final int SIZE = 3;
    static int COUNT = 0;

    public static void main(String[] args) {
        User.Computer computer = new User.Computer(auto.generator(SIZE));
        System.out.println("computer가 생성한 숫자 = " + computer.numbers());

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            try {
                User.Player player = new User.Player(input.generator(SIZE));
                Match with = basic.with(computer.numbers(), player.numbers());

                if (with.equals(Match.크다)) {
                    System.out.println("입력한 숫자가 더 큽니다.");
                    COUNT++;
                }

                if (with.equals(Match.작다)) {
                    System.out.println("입력한 숫자가 더 작습니다.");
                    COUNT++;
                }

                if (with.equals(Match.같다)) {
                    System.out.println("컴퓨터가 생성한 숫자를 모두 맞췄습니다. 다시 시도한 입력횟수: " + COUNT);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
