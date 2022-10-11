public class ConcurrentStackOperationsFixed {

    public static void main(String[] args) throws InterruptedException {
        Stack<Integer> stack = ArrayStack.synchronizedStack(new ArrayStack<>());
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                stack.push(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                stack.push(i);
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int stackSize = 0;
        while (!stack.isEmpty()) {
            stack.pop();
            stackSize++;
        }
        System.out.println("stack size is " + stackSize);
    }
}
