package code2;

import static java.util.Objects.isNull;

public abstract class Human{
    public int x;
    public int y;
    public int age;
    public int height;
    public int weight;
    public int money;

    public Human(int x, int y, int age, int height, int weight, int money){
        if(isNull(x)){
            throw new IllegalArgumentException("x 좌표값이 null 입니다.");
        }
        if(isNull(y)){
            throw new IllegalArgumentException("y 좌표값이 null 입니다.");
        }
        if(isNull(age) || age <= 0){
            throw new IllegalArgumentException("나이가 올바르지 않습니다.");
        }
        if(isNull(height) || height <= 0){
            throw new IllegalArgumentException("키가 올바르지 않습니다.");
        }
        if(isNull(weight) || weight <= 0){
            throw new IllegalArgumentException("몸무게가 올바르지 않습니다.");
        }
        if(isNull(money) || money < 0){
            throw new IllegalArgumentException("소지금이 올바르지 않습니다.");
        }
        this.x = x;
        this.y = y;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.money = money;
    }

    public void walk(){
        System.out.println(" 걷는다. ");
    }

    public void talk(){
        System.out.println(" 말한다. ");
    }

    public void eat(){
        System.out.println(" 먹는다. ");
        weight++;
    }

    public abstract void payments(String move, int sales);

    public void info(){
        System.out.println(" 나이는 "+ age);
        System.out.println(" 키는 "+ height);
        System.out.println(" 몸무게는 "+ weight);
        System.out.println(" 소지금은 "+ money);
    }
}
