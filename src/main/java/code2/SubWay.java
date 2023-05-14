package code2;

public record SubWay() {

    public void ride(Yeop yeop){
        yeop.payments("subway",1_400);
    }
}
