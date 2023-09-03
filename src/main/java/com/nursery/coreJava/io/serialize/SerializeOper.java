package com.nursery.coreJava.io.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * <序列化><br>
 *
 * @author jasonbrourne
 * @time 2022/3/7 17:35
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SerializeOper {

    public static void main(String[] args) {
        Employee e = new Employee();
        Employee.name = "ReyanAli";
        e.address = "PhokkaKuan";
        e.SSN = 11122333;
        e.number = 101;
        e.fatherName = "Fathre";
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("./src\\main\\java\\com\\nursery\\coreJava\\io\\serialize/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
