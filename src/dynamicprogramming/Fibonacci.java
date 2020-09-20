package dynamicprogramming;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        int byIter = calculateFibonacciByIterator(7);
        System.out.println("calculateFibonacciByIterator:"+byIter);
        int byRecu = calculateFibonacciByRecursion(7);
        System.out.println("calculateFibonacciByRecursion:"+byRecu);
    }

    /**
     * 使用迭代的方式计算斐波那契数列
     * @param n
     * @return
     */
    static int calculateFibonacciByIterator(int n){
        if(n<=1)
            return n;
        int fib1 = 0;
        int fib2 = 1;
        int fib = 0;
        while(n>1){
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
            n--;
        }
        return fib;
    }

    /**
     * 使用递归的方式计算斐波那契数列
     * @param n
     * @return
     */
    static int calculateFibonacciByRecursion(int n){
        if(n<=1)
            return n;
        return calculateFibonacciByRecursion(n-1)+calculateFibonacciByRecursion(n-2);
    }
}
