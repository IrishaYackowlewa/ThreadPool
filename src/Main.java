public class Main {

    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(3);
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
    }
}
