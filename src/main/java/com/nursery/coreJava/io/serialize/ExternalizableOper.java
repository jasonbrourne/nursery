package com.nursery.coreJava.io.serialize;

import java.io.*;

/**
 * <Externalizable ><br>
 *
 * @author jasonbrourne
 * @time 2022/3/8 17:20
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ExternalizableOper implements Externalizable {

    private String name;
    private int age;

    //注意，必须加上pulic 无参构造器
    public ExternalizableOper() {
    }

    public ExternalizableOper(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //将name反转后写入二进制流
        StringBuffer reverse = new StringBuffer(name).reverse();
        System.out.println(reverse.toString());
        out.writeObject(reverse);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //将读取的字符串反转后赋值给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        System.out.println(name);
        this.age = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExPerson.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ExPerson.txt"))) {
            oos.writeObject(new ExternalizableOper("brady", 23));
            ExternalizableOper ep = (ExternalizableOper) ois.readObject();
            System.out.println(ep);
        }
    }
}
