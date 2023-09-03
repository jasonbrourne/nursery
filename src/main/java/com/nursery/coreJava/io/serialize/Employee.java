package com.nursery.coreJava.io.serialize;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <a simple bean><br>
 *
 * @author jasonbrourne
 * @time 2022/3/7 17:32
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Employee extends EmployFather implements java.io.Serializable {
    public static String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

    private void writeObject(ObjectOutputStream out) throws Exception {
        ObjectOutputStream.PutField putFields = out.putFields();
        putFields.put("address", address + "-1");
        out.writeFields();
    }
    private void readObject(ObjectInputStream in) throws Exception {
        ObjectInputStream.GetField readFields = in.readFields();
        String encryptionPassword = (String) readFields.get("address", "");
        // 模拟解密
        address = encryptionPassword.substring(0, encryptionPassword.indexOf('-'));
    }
}
