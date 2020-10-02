package dynamicprogramming;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int byIter = calculateFibonacciByIterator(39);
        long endTime1 = System.currentTimeMillis();
        System.out.println("calculateFibonacciByIterator:"+byIter+",cost "+(endTime1 - startTime) +"ms.");
        startTime = System.currentTimeMillis();
        int byRecu = calculateFibonacciByRecursion(39);
        long endTime2 = System.currentTimeMillis();
        System.out.println("calculateFibonacciByRecursion:"+byRecu+",cost "+(endTime2 - startTime) +"ms.");
        startTime = System.currentTimeMillis();
        int byRecuUseMemo = calculateFibonacciByRecursionUseMemory(39,new int[40]);
        long endTime3 = System.currentTimeMillis();
        System.out.println("calculateFibonacciByRecursionUseMemory:"+byRecuUseMemo+",cost "+(endTime3 - startTime) +"ms.");
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

    /**
     * 使用递归的方式计算斐波那契数列，并通过备忘录来避免重复计算
     * @param n
     * @param memo
     * @return
     */
    static int calculateFibonacciByRecursionUseMemory(int n,int[] memo){
        if(n == 0 || n == 1)
            return n;
        if(memo[n] != 0) return memo[n];
        if (n>1){
            memo[n] = calculateFibonacciByRecursionUseMemory(n-1,memo)+calculateFibonacciByRecursionUseMemory(n-2,memo);
            return memo[n];
        }
        return 0;
    }
}
