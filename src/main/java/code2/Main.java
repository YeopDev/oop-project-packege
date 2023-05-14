package code2;

public class Main {
    public static void main(String[] args) {

        // 인터페이스 공부
        Yeop yeop = new Yeop(0,0,24,180,75,10_000);

        yeop.walk();
        yeop.talk();
        yeop.eat();

        Bus bus = new Bus();
        bus.ride(yeop);

        SubWay subWay = new SubWay();
        subWay.ride(yeop);

        yeop.info();
    }
}
