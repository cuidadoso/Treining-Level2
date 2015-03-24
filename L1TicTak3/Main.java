package tictak3;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Data    d = new Data();
        Worker1 w1=new Worker1(1, d);
        Worker2 w2=new Worker2(2, d);

        w2.join();
        System.out.println("end of mian...");
    }
}
