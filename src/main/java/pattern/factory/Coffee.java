package pattern.factory;

public abstract class Coffee {
    public abstract int getPrice();

    @Override
    public String toString() {
        return "this coffee is " + this.getPrice();
    }
}
