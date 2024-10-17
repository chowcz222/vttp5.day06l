package appdata;

public class App {

    public static void main(String[] args) {
        
        Thread th = new Thread(new Runnable() {

            public void run() {

                for(int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " -> " +i);
                }
            }    
        });
        th.start();
    }
}