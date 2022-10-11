import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IteratingAndAddingConcurrentlyFixed {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> syncedNumbers = Collections.synchronizedList(new ArrayList<>());

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                syncedNumbers.add(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        Thread.sleep(50);
        
        synchronized (syncedNumbers) {
            Iterator<Integer> iterator = syncedNumbers.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                Thread.sleep(10);
            }
        }

        thread.join();
    }
}
