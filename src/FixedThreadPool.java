import java.util.ArrayDeque;

public class FixedThreadPool  implements ThreadPool{
    private final int countTreads;
    private final Thread[] threads;
    private final ArrayDeque<Runnable> queue = new ArrayDeque<>();
    private final Object lockWait = new Object();
    private int c;
    private boolean flag = true;

    public FixedThreadPool(int countTreads) {
        this.countTreads = countTreads;
        threads = new Thread[countTreads];
    }

    @Override
    public void start() {
        for (int i = 0; i < countTreads; i++) {
            threads[i] = new Thread(new RunThread());
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        c++;
        flag = false;
        synchronized (lockWait) {
            queue.add(runnable);
            lockWait.notify();
        }
    }

    private class RunThread implements Runnable {
        @Override
        public void run() {
            while (flag || c != 0) {
                synchronized (lockWait) {
                    if (queue.peek() == null ) {
                        System.out.println("поток ждет");
                        try {
                            lockWait.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread.currentThread().interrupt(); //правильна обработка этого исключения, пока мало понимаю");
                            System.out.println("log.debug(); //правильна обработка этого исключения, пока мало понимаю");
                            e.printStackTrace();
                        }
                    }
                    else {
                        queue.poll().run();
                        c--;
                    }
                }
            }
        }
    }
}
