package com.nursery.coreJava.io.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * <反序列化><br>
 *
 * @author jasonbrourne
 * @time 2022/3/7 17:36
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DeserializeCase {
    public static void main(String[] args) {
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("./src\\main\\java\\com\\nursery\\coreJava\\io\\serialize/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + Employee.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
        System.out.println("FatherName: " + e.fatherName);
    }
}
