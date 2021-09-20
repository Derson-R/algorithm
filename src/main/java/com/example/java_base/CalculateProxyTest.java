package com.example.java_base;

import com.example.pojo.Calculate;
import com.example.pojo.CalculateInterface;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author rds
 * @date 2021-09-18 18:57
 *
 * 静态代理：目标类跟代理类同时实现同一个接口，且实现接口中的方法，在代理类中增加对目标类方法的增强处理
 *
 *           缺点：每个类都需要写个代理类
 *
 *
 * 动态代理： 需要了解创建对象机制，java创建对象的本质其实是.class文件通过类加载器生成Class类的对象，通过Class<Calculate> 的构造器来创建对象；
 *
 *          动态代理的本质就是要拿到 Class<>类就行了
 *
 *   由JDK提供的反射接口 ：java.lang.reflect.InvocationHandler 跟 反射类： java.lang.reflect.Proxy 来实现
 **/
public class CalculateProxyTest {
    public static void main(String[] args) throws Exception{
        /**
         * 静态代理test
         */
        /*Calculate calculate = new Calculate();
        CalculateInterface calculateInterface = new CalculateProxy(calculate);
        calculateInterface.add();*/

        /**
         * 动态代理
         */
        /*//通过CalculateInterface 类加载器把 CalculateInterface 加载到内存中；
        Class proxyClass = Proxy.getProxyClass(Calculate.class.getClassLoader(), Calculate.class.getInterfaces());
        //得到有参构造器
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        //反射创建代理实例(它类型必须是接口)
        CalculateInterface calculateProxy = (CalculateInterface)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //手动new一个目标对象
                Calculate calculate = new Calculate();
                //反射执行目标对象方法，返回目标对象执行结果
                System.out.println("add前");
                Object result = method.invoke(calculate, objects);
                System.out.println("add后");
                return result;
            }
        });
        calculateProxy.add();*/
        Calculate calculate = new Calculate();
        CalculateInterface calculateProxy = (CalculateInterface)CalculateProxyTest.getProxy(calculate);
        calculateProxy.reduce();


    }

    //只需要实现类（目标类）跟接口 这两个类就可以直接创建代理类
    public static Object getProxy(final Object target) throws Exception{
        Class proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        //这里通过有参构造函数创建接口的代理类对象，这里入参可以理解为代理构造函数入参就是目标类，invoke方法就是代理方法
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        Object targetProxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("增强方法前");
                Object result = method.invoke(target,objects);
                System.out.println("增强方法后");
                return result;
            }
        });
        return targetProxy;
    }



    //有时间需要看看动态代理的使用实例，AOP及其他场景
}
