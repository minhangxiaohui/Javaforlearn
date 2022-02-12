package Deunicode;

import org.springframework.jndi.JndiTemplate;

import javax.naming.NamingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User implements Serializable {
    private  String username;
    private  String age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public User() {

    }
    public User(String username,String age) {
        this.age=age;
        this.username=username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        System.out.println("调用了set");this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
//    private void initFuntion(){
//        JndiTemplate jt = new JndiTemplate();
//        try {
//            jt.lookup(age);
//        }catch (NamingException e){
//            e.printStackTrace();
//        }
//    }
//    private void readObject(ObjectInputStream in){
//        try {
//            in.defaultReadObject();
////            initFuntion();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    private  void writeObject(ObjectOutputStream out){
//        try {
//            out.defaultWriteObject();
//            System.out.println("反序列化成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }

}
