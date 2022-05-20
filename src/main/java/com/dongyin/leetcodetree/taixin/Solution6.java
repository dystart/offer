package com.dongyin.leetcodetree.taixin;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**贪心算法加油站
 * @author dystart
 * @create 2022-04-11 13:51
 */
public class Solution6 {
    public CopyOnWriteArrayList copy;
    public static Semaphore semaphore;

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(4);
        AtomicReference<Solution> integerAtomicReference = new AtomicReference<>(new Solution());
        ExecutorService executorService = newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("HHH");
            }
        });
        executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });
    }


    //加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {return 0;
    }
}
