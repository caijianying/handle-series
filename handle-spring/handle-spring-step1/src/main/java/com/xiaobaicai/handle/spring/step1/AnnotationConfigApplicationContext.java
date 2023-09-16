package com.xiaobaicai.handle.spring.step1;


import com.xiaobaicai.handle.spring.step1.annotations.Component;
import com.xiaobaicai.handle.spring.step1.annotations.ComponentScan;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caijy
 * @description TODO
 * @date 2023/9/11 星期一 6:46 下午
 */
public class AnnotationConfigApplicationContext {

    private Class configClass;

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap(256);

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap(256);

    public AnnotationConfigApplicationContext(Class clazz) {
        this.configClass = clazz;
        scan();
    }

    public void scan() {
        ComponentScan componentScanAnnotation = (ComponentScan) this.configClass.getAnnotation(ComponentScan.class);
        String[] basePackages = null;
        if (componentScanAnnotation != null && componentScanAnnotation.basePackages() != null) {
            basePackages = componentScanAnnotation.basePackages();
            for (String basePackage : basePackages) {
                // 扫描
                URL resource = AnnotationConfigApplicationContext.class.getClassLoader().getResource(basePackage.replace(".", "/"));
                File file = new File(resource.getFile());
                readFile(file, basePackage);
            }
        }
    }

    public void readFile(File file, String basePackage) {
        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                readFile(listFile, basePackage);
            }
        } else {
            String replace = basePackage.replace(".", "/");
            String absolutePath = file.getAbsolutePath();
            String name = absolutePath.substring(absolutePath.indexOf(replace), absolutePath.indexOf(".class"));
            String className = name.replace("/", ".");
            try {
                Class<?> aClass = AnnotationConfigApplicationContext.class.getClassLoader().loadClass(className);
                Component componentAnnotation = aClass.getDeclaredAnnotation(Component.class);
                if (componentAnnotation == null) {
                    return;
                }
                String value = componentAnnotation.value();
                String beanName;
                if (value != null && value.length() > 0) {
                    beanName = value;
                } else {
                    beanName = className.substring(className.lastIndexOf("."));
                }
                BeanDefinition definition = new BeanDefinition(aClass);
                beanDefinitionMap.put(beanName, definition);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            BeanDefinition bd = beanDefinitionMap.get(beanName);
            Object beanInstance = createBean(beanName, bd);
            return beanInstance;
        }
        return singletonObject;
    }

    private Object createBean(String beanName, BeanDefinition bd) {
        Object beanInstance = null;
        try {
            beanInstance = bd.getClazz().getDeclaredConstructor().newInstance();
            singletonObjects.put(beanName, beanInstance);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return beanInstance;
    }

    public Class getConfigClass() {
        return configClass;
    }

    public void setConfigClass(Class configClass) {
        this.configClass = configClass;
    }
}
