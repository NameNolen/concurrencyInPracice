package chapter3;

/**
 * NoVisibility可能会持续循环下去，因为该程序可能永远都看不到ready的值。
 * 还有一种更奇怪的现象时，NoVisibility可能会输出0；因为该线程可能看到了
 * 写入ready的值，但却没有考到之后写入number的值。这种现象成为‘重排序’Reordering
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run(){
            while(!ready) Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args){
        new ReaderThread().start();
        number = 47;
        ready = true;
    }
}
