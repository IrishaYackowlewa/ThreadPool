public class Main {

    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(5);
        fixedThreadPool.start();
        fixedThreadPool.execute(()->System.out.println("Задача 1"));
        fixedThreadPool.execute(()->System.out.println("Задача 2"));
        fixedThreadPool.execute(()->System.out.println("Задача 3"));
        fixedThreadPool.execute(()->System.out.println("Задача 4"));
        fixedThreadPool.execute(()->System.out.println("Задача 5"));
        fixedThreadPool.execute(()->System.out.println("Задача 6"));
        fixedThreadPool.execute(()->System.out.println("Задача 7"));
        fixedThreadPool.execute(()->System.out.println("Задача 8"));
        fixedThreadPool.execute(()->System.out.println("Задача 9"));
        fixedThreadPool.execute(()->System.out.println("Задача 10"));
        fixedThreadPool.execute(()->System.out.println("Задача 11"));
        fixedThreadPool.execute(()->System.out.println("Задача 12"));
        fixedThreadPool.execute(()->System.out.println("Задача 13"));
        fixedThreadPool.execute(()->System.out.println("Задача 14"));
        fixedThreadPool.execute(()->System.out.println("Задача 15"));
        fixedThreadPool.execute(()->System.out.println("Задача 16"));
        fixedThreadPool.execute(()->System.out.println("Задача 17"));

        ScalableThreadPool scalableThreadPool = new ScalableThreadPool(3, 4);
        scalableThreadPool.start();
        scalableThreadPool.execute(()->System.out.println("Задача 1"));
        scalableThreadPool.execute(()->System.out.println("Задача 2"));
        scalableThreadPool.execute(()->System.out.println("Задача 3"));
        scalableThreadPool.execute(()->System.out.println("Задача 4"));
        scalableThreadPool.execute(()->System.out.println("Задача 5"));
        scalableThreadPool.execute(()->System.out.println("Задача 6"));
        scalableThreadPool.execute(()->System.out.println("Задача 7"));
        scalableThreadPool.execute(()->System.out.println("Задача 8"));
        scalableThreadPool.execute(()->System.out.println("Задача 9"));
        scalableThreadPool.execute(()->System.out.println("Задача 10"));
        scalableThreadPool.execute(()->System.out.println("Задача 11"));
        scalableThreadPool.execute(()->System.out.println("Задача 12"));
        scalableThreadPool.execute(()->System.out.println("Задача 13"));
        scalableThreadPool.execute(()->System.out.println("Задача 14"));
        scalableThreadPool.execute(()->System.out.println("Задача 15"));
        scalableThreadPool.execute(()->System.out.println("Задача 16"));
        scalableThreadPool.execute(()->System.out.println("Задача 17"));
    }
}
