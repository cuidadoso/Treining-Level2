package ex1;

public class Ex1 {
    public static void main(String[] args) 
                        throws InterruptedException {
        TaskManager tm=new TaskManager();
        Client cl1=new Client("Delete All");
        Client cl2=new Client("Read DB data");
        
        tm.addTaskListener(cl1);
        tm.addTaskListener(cl2);
        
        tm.works();
        
        tm.removeTaskListener(cl1);
        tm.removeTaskListener(cl2);
    }
}
