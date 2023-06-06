package pattern.factory;

public class CoffeeMadeMain {
    public static void main(String[] args) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Coffee latte = coffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = coffeeFactory.getCoffee("Americano", 3000);
        System.out.println("Factory latte ::" + latte);
        System.out.println("Factory americano ::" + americano);
        System.out.println("상속관계의 두 객체에서 상위클래스가 중요한 뼈대를 결정하고 하위클래스가 구체적인 구현내용을 결정하는 패턴");
    }
}