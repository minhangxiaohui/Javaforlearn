import org.springframework.jndi.JndiTemplate;

import javax.naming.NamingException;
import java.io.*;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    private void initFuntion(){
        JndiTemplate jt = new JndiTemplate();
        try {
            jt.lookup(age);
        }catch (NamingException e){
            e.printStackTrace();
        }
    }
    private void readObject(ObjectInputStream in){
        try {
            in.defaultReadObject();
            initFuntion();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private  void writeObject(ObjectOutputStream out){
        try {
            out.defaultWriteObject();
            System.out.println("反序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
