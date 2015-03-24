package ex1;

public class Client implements TaskListener,Runnable {
    private String  name;
    private boolean work;
    
    public Client(String name) {
        this.name=name;
        (new Thread(this)).start();
    }
    @Override
    public void start(TaskData ev) {
        System.out.println("start "+name+" "+ev.getDate());
        work=true;
        synchronized(this)  {
            notify();
        }
    }
    @Override
    public void stop(TaskData ev) {
        System.out.println("stop "+name+" "+ev.getDate());
        work=false;
    }
    @Override
    public void run() {
     try{
        synchronized(this)  {
            while(!work) wait();
        }
        while(work){
            System.out.println("works...");
            Thread.sleep(100);
        }
     }catch(InterruptedException ex){ex.printStackTrace();}
        System.out.println("ends...");
    }
}
