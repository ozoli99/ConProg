import java.util.ArrayList;
import java.util.List;

public class MultithreadCounter {

    private static long counter;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> counterThreads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            counterThreads.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increment();
                }
            }));
        }

        for (Thread thread : counterThreads) {
            thread.start();
        }
        for (Thread thread : counterThreads) {
            thread.join();
        }
        System.out.println(getCounter());
    }

    private static synchronized void increment() { counter++; }
    private synchronized static void increment2() { counter++; }
    private static synchronized long getCounter() { return counter; }
}
