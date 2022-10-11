public class WaitForFlag {

    private static boolean isFinished;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
           for (int i = 0; i < 50; i++) {
               System.out.println(i);
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
           setFinished();
        });
        thread.start();

        while (true) {
            Thread.sleep(50);
            if (isFinished()) {
                break;
            }
        }
    }

    private static synchronized void setFinished() { isFinished = true; }
    private static synchronized boolean isFinished() { return isFinished; }
}
