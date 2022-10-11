public class JoinWithLimitedWait {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        long start = System.currentTimeMillis();
        thread.start();

        while (thread.isAlive()) {
            long elapsedSeconds = (System.currentTimeMillis() - start) / 1000;
            System.out.println("a szal meg mindig fut, eltelt eddig " + elapsedSeconds + " masodperc");
            thread.join(2000);
        }

        long elapsedSeconds = (System.currentTimeMillis() - start) / 1000;
        System.out.println("a szal futasa veget ert " + elapsedSeconds + " masodperc alatt");
    }
}
