package code2;

import static java.util.Objects.isNull;

public class Yeop extends Human{
    public Yeop(int x, int y, int age, int height, int weight, int money) {
        super(x, y, age, height, weight, money);
    }

    @Override
    public void payments(String move, int sales) {
        System.out.println(move + "를 결제한다. ");
        if(sales <= 0){
            throw new IllegalArgumentException("금액이 올바르지 않습니다.");
        }
        money -= sales;
    }
}
