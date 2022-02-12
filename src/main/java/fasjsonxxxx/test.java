package fasjsonxxxx;

import com.alibaba.fastjson.JSON;

class User1 {
    private String username;

    public User1() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("调用了set");
        this.username = username;
    }
}

public class test {
    public static void main(String[] args) {
        String Userzhousl = "{\"@type\":\"fasjsonxxxx.User1\",\"username\":\"zhousl\"}";
        User1 user1 = JSON.parseObject(Userzhousl, User1.class);
        System.out.println("反序列化后的对象:"+user1.getUsername());
    }
}