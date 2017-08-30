package gjj.dynamic.proxy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.reflect.Proxy

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //初始化连接代理类和委托类
        var timingInvocationHandler=TimingInvocationHandler(OperateImp())
        //Proxy.newProxyInstance  生成动态代理对象
        var operate=Proxy.newProxyInstance(Operate::class.java.classLoader, arrayOf(Operate::class.java),timingInvocationHandler) as? Operate

        //调用代理对象函数，会先调用invocationHandler中的invoke函数
        //invoke 函数中实现调用委托类对象的对于函数
        // call method of proxy instance
        operate?.operateMethod1()
        System.out.println()
        operate?.operateMethod2()
        System.out.println()
        operate?.operateMethod3()

    }
}
