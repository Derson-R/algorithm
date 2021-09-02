package com.example.pojo;

import java.util.Objects;

public class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

   /* @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            return user.getAge().compareTo(this.age);
        }
        throw new ClassCastException("不能转换为User类型");
    }
*/
/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                age.equals(user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/
}
