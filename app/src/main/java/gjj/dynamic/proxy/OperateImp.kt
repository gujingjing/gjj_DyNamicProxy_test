package gjj.dynamic.proxy

/**
 * 作者：l on 2017/8/30 11:50
 * 邮箱：gujj512@163.com
 */
class OperateImp : Operate {

    override fun operateMethod1() {
        println("Invoke operateMethod1")
        sleep(110)
    }

    override fun operateMethod2() {
        println("Invoke operateMethod2")
        sleep(120)
    }

    override fun operateMethod3() {
        println("Invoke operateMethod3")
        sleep(130)
    }

    fun sleep(millSeconds: Long) {
        try {
            Thread.sleep(millSeconds)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}
