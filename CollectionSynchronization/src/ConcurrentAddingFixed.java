import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentAddingFixed {

    private static List<Integer> syncedNumbers = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                syncedNumbers.add(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                syncedNumbers.add(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(syncedNumbers.size());
    }
}
