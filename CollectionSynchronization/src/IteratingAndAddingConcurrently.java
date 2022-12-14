import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratingAndAddingConcurrently {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                numbers.add(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        Thread.sleep(50);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            Thread.sleep(10);
        }

        thread.join();
    }
}
