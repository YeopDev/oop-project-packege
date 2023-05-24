package carRacing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRacingMain {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("자동차 이름을 입력하세요.");
        String carNameInput = sc.nextLine();
        List<Car> cars = Arrays.stream(carNameInput.split(","))
                .map(car -> new Car(car, 0, new RandomMovePolicy()))
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
