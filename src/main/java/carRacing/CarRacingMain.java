package carRacing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingMain {
        /*
        1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
        2. 각 자동차의 이름을 부여할 수 있다. 전진하는 자동차를 출력할 떄 자동차 이름을 같이 출력한다.
        3. 자동차 이름은 , (쉼표)를 기준으로 구분하며 이름은 5자 이하만 가능.
        4. 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야한다.
        5. 전진하는 조건은 0에서 9사이에서 랜덤 값을 구한 후 랜덤값이 4 이상이면 전진, 3이하의 값이면 멈춘다.
        6. 자동차 경주 게임을 누가 우승했는지를 알려준다.
        7. 우승자는 한대 이상일 수 있다.
        */
        private static final Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.println("자동차 이름을 입력하세요.");
            String carNameInput = sc.nextLine();
            List<Car> cars = Arrays.stream(carNameInput.split(","))
                    .map(car -> new Car(car, 0))
                    .toList();

            System.out.println("몇 턴을 실행 하실건지 입력해주세요.");
            int rounds = sc.nextInt();
            Race race = new Race(cars);
            race.start(rounds);

            List<Car> winnerCars = race.winners();
            System.out.printf("우승자: %s", winnerCars.stream()
                    .map(winner -> String.format(winner.name() + " - " + winner.distance() + "칸"))
                    .collect(Collectors.joining(", \n"))
            );
        }
}
