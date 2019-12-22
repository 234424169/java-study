package future;

/**
 * All rights Reserved, Designed By alibaba-inc.com
 *
 * @author 烽华 (Edison Chen) ziyi.chen@alibaba-inc.com
 * @Title: BaseMethod.java
 * @Package future
 * @Description:
 * @date 2019-12-22
 */
public class BaseMethod {

    public static void rpcService(){
        //模拟rpc调用使用100ms耗时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void httpService(){
        //模拟rpc调用使用200ms耗时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void calcuteTime(Long startTime){
        System.out.println("总耗时为" + String.valueOf(System.currentTimeMillis() - startTime) + "毫秒");
    }
}
