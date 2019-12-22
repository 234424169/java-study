package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * All rights Reserved, Designed By alibaba-inc.com
 *
 * @author 烽华 (Edison Chen) ziyi.chen@alibaba-inc.com
 * @Title: FutureCase.java
 * @Package future
 * @Description:
 * @date 2019-12-22
 */
public class FutureCase {

    public static void main(String[] args) {
        try {
            blockCase();
            futureCase();
            completableFutureCase();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void blockCase() {
        System.out.println("阻塞调用");
        Long startTime = System.currentTimeMillis();
        BaseMethod.httpService();
        BaseMethod.rpcService();
        BaseMethod.calcuteTime(startTime);
    }

    final static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void futureCase() throws Exception {
        System.out.println("使用future异步调用");
        Long startTime = System.currentTimeMillis();
        Future future1 = pool.submit(() -> BaseMethod.rpcService());

        Future future2 = pool.submit(() -> BaseMethod.httpService());

        future1.get();
        future2.get();


        BaseMethod.calcuteTime(startTime);
    }

    public static void completableFutureCase() throws Exception {
        System.out.println("使用completableFuture异步调用");
        Long startTime = System.currentTimeMillis();
        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> BaseMethod.rpcService(), pool),

                CompletableFuture.runAsync(() -> BaseMethod.httpService(), pool)
        ).get();

        BaseMethod.calcuteTime(startTime);
    }

}
