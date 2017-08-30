package gjj.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 作者：l on 2017/8/30 11:53
 * 邮箱：gujj512@163.com
 * 负责连接委托类和代理类中间必须实现的接口
 */
public class TimingInvocationHandler implements InvocationHandler {

    //表示委托类对象
    private Object target;

    public TimingInvocationHandler() {}

    public TimingInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy     代理类对象
     * @param method    代理对象被调用的函数
     * @param args      代理对象被调用的函数参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = method.invoke(target, args);
        System.out.println(method.getName() + " cost time is:" + (System.currentTimeMillis() - start));
        return obj;
    }
}
