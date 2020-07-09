import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ScalableThreadPool implements ThreadPool{
    private final int MAXCountThreads;
    private final int MINCountThreads;
    private final List<Thread> threads;
    private final ArrayDeque<Runnable> queue = new ArrayDeque<>();
    private final Object lockWait = new Object();
    private int countOper;
    private boolean flag = true;

    public ScalableThreadPool(int minCountThreads, int maxCountThreads) {
        this.MAXCountThreads = maxCountThreads;
        this.MINCountThreads = minCountThreads;
        this.threads = new ArrayList<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < this.MINCountThreads; i++) {
            Thread thread = new Thread(new ScalableThreadPool.RunThread());
            threads.add(thread);
            thread.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        flag = false;
        boolean stateThread = true;

        synchronized (lockWait) {
            countOper++;
            queue.add(runnable);
            lockWait.notify();
        }

        for (Thread thread: threads) {//проверяю статус потоков
            //System.out.println(thread.getState());
            if (thread.getState() != Thread.State.RUNNABLE){//если все работают
                stateThread = false;
                break;
            }
        }

        if (stateThread && threads.size() < MAXCountThreads) {//добавляю еще потоков до максимума
            int countNewThread = this.MAXCountThreads - this.MINCountThreads;
            for (int i = 0; i < countNewThread; i++) {
                //System.out.println("Добавляем еще поток");
                Thread thread = new Thread(new ScalableThreadPool.RunThread());
                threads.add(thread);
                thread.start();
            }
        }
    }

    private class RunThread implements Runnable {
        @Override
        public void run() {
            synchronized (lockWait) {
                while (flag || countOper != 0) {
                    if (queue.peek() == null) {
                       // System.out.println("поток ждет");
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
                        countOper--;
                    }
                    if (queue.size() == 0 && threads.size() > MINCountThreads) {
                        for (int i = MAXCountThreads - 1; i > MINCountThreads-1; i--) {
                            //System.out.println("Удалили поток");
                            threads.remove(i);
                        }
                    }
                    //System.out.println(threads.size());
                }
            }
        }
    }
}
