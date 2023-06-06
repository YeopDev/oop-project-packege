package pattern.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();
        System.out.println("singletonA.hashCode() = " + singletonA.hashCode());
        System.out.println("singletonB.hashCode() = " + singletonB.hashCode());
        if(singletonA == singletonB){
            System.out.println("true = " + true);
            System.out.println("하나의 클래스에 오직 하나의 인스턴스만 가지는 패턴");
            System.out.println("의존성 주입 추가");
        }
    }
}
