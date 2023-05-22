package carRacing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
        private List<Car> cars;

        public Race(List<Car> cars) {
            if (cars.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 리스트가 비어있습니다.");
            }
            this.cars = cars;
        }

        public void startRace(int rounds) {
            IntStream.range(0, rounds).forEach(i -> cars.forEach(Car::move));
        }

        public List<Car> winners() {
            int maxDistance = this.cars.stream()
                    .mapToInt(Car::distance)
                    .max()
                    .orElse(0);

            return this.cars.stream()
                    .filter(car -> car.distance() == maxDistance)
                    .collect(Collectors.toList());
        }
}
