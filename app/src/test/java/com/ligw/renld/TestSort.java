package com.ligw.renld;

import android.hardware.lights.LightState;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author created by ligw on 2022/8/16
 * @Email ligw@wanbu.com.cn
 */
public class TestSort {


    @Test
    public void mainTest() throws Exception {
        Class clazz = Class.forName("com.ligw.renld.FanShe");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }



        Object o = (FanShe) clazz.newInstance();
        Method test = clazz.getDeclaredMethod("test", new Class[]{String.class, int.class});
        test.setAccessible(true);
        test.invoke(o,"lisi",20);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        Object o1 = name.get(o);
        System.out.println(o1);
        //System.out.println(fanShe.name);

//        List<Bean> list = new ArrayList<>();
////        Bean bean = new Bean();
////        bean.time = 1000;
////        Bean bean1 = new Bean();
////        bean1.time = 1001;
////        Bean bean2 = new Bean();
////        bean2.time = 1003;
////        Bean bean3 = new Bean();
////        bean3.time = 999;
////        list.add(bean);
////        list.add(bean1);
////        list.add(bean2);
////        list.add(bean3);
////        Collections.sort(list, (o1, o2) -> {
////            int a = -1;
////            if(o1.time - o2.time <= 0){
////                a = -1;
////            }else{
////                a = 1;
////            }
////            return a;
////        });
//        list.sort(new Comparator<Bean>() {
//            @Override
//            public int compare(Bean o1, Bean o2) {
//                return o1.time - o2.time;
//            }
//        });
//        System.out.println(list);

    }

    static class Bean{
        public int time;

        @Override
        public String toString() {
            return "Bean{" +
                    "time=" + time +
                    '}';
        }
    }

}
