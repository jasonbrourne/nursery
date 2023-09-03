package com.nursery.coreJava.reflect.aop;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <AspectLoader><br>
 *
 * @author jasonbrourne
 * @time 2022/2/24 2:39
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AspectLoader {
    /**
     * 配置扫描aop的aspect基础包路径
     */
    public static final String PACKAGE_NAME = "com.nursery.coreJava.reflect.aop";
    /**
     * 模拟ioc容器
     */
    public Map<String, Object> beanContainer = new HashMap<>();
    public AspectLoader() {
        this.beanContainer.put("TestMethod", new TestMethod());
    }
    public static void main(String[] args) {
        AspectLoader aspectLoader = new AspectLoader();
        aspectLoader.init();
        TestMethod testMethod = (TestMethod) aspectLoader.beanContainer.get("TestMethod");
        testMethod.doTest();
    }
    /**
     * 初始化aop的配置相关
     */
    private void init() {
        try {
            //获取切面点aspect
            List<Class> targetsWithAspectJAnnotationList = this.getAspectClass();
            for (Class targetsWithAspectJAnnotation : targetsWithAspectJAnnotationList) {
                Method beforeMethod = this.getBeforeMethod(targetsWithAspectJAnnotation);
                Pointcut pointcut = (Pointcut) this.getMethodAnnotation(targetsWithAspectJAnnotation, Pointcut.class);
                Method afterMethod = this.getAfterMethod(targetsWithAspectJAnnotation);

                List<Class> classList = this.getClassFromPackage(AspectLoader.class, pointcut.value().substring(0, pointcut.value().indexOf("*") - 1));
                for (Class sourceClass : classList) {
                    Object aspectObject = targetsWithAspectJAnnotation.newInstance();
                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(sourceClass);
                    enhancer.setCallback(new MethodInterceptor() {
                        @Override
                        public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                            beforeMethod.invoke(aspectObject, method, obj);
                            methodProxy.invokeSuper(obj, objects);
                            afterMethod.invoke(aspectObject,method,obj);
                            return obj;
                        }
                    });
                    Object proxyObj = enhancer.create();
                    this.beanContainer.put(sourceClass.getSimpleName(), proxyObj);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private List<Class> getAspectClass() throws ClassNotFoundException, IOException {
        final ClassPath classPath = ClassPath.from(AspectLoader.class.getClassLoader());
        List<Class> aspectClass = new ArrayList<>();
        ImmutableSet<ClassPath.ClassInfo> clazz = classPath.getAllClasses();
        List<ClassPath.ClassInfo> list = clazz.asList();
        for (ClassPath.ClassInfo classInfo : list) {
            if (classInfo.getName() != null && classInfo.getPackageName().contains(PACKAGE_NAME)) {
                Class clazzTemp = Class.forName(classInfo.getName());
                if (clazzTemp.isAnnotationPresent(Aspect.class)) {
                    aspectClass.add(clazzTemp);
                }
            }
        }
        return aspectClass;
    }

    /**
     * 获取指定包名下边的所有类
     *
     * @param source
     * @param packageName
     * @return
     * @throws Exception
     */
    private List<Class> getClassFromPackage(Class source, String packageName) {
        List<Class> classList = new ArrayList<>();
        final ClassPath classPath;
        try {
            classPath = ClassPath.from(source.getClassLoader());
            ImmutableSet<ClassPath.ClassInfo> clazz = classPath.getAllClasses();
            List<ClassPath.ClassInfo> list = clazz.asList();
            for (ClassPath.ClassInfo classInfo : list) {
                if (classInfo.getName() != null && classInfo.getPackageName().contains(packageName)) {
                    classList.add(Class.forName(classInfo.getName()));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classList;
    }

    private Annotation getMethodAnnotation(Class source, Class annotationClass) {
        Method[] methods = source.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                Annotation[] beforeArr = method.getAnnotationsByType(annotationClass);
                if (beforeArr.length > 0) {
                    return beforeArr[0];
                }
            }
        }
        return null;
    }
    private Method getBeforeMethod(Class source) {
        Method[] methods = source.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {
                return method;
            }
        }
        return null;
    }
    private Method getAfterMethod(Class source) {
        Method[] methods = source.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(After.class)) {
                return method;
            }
        }
        return null;
    }
}
