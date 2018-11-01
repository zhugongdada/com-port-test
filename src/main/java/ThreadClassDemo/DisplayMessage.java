package ThreadClassDemo;

/**
 * Created by 64960 on 2018.10.18.
 */
public class DisplayMessage implements Runnable{
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}
