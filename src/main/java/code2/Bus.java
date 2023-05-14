package code2;

public record Bus() {
    public void ride(Yeop yeop){
        yeop.payments("bus",1_200);
    }
}
