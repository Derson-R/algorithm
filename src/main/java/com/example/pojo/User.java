package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Cloneable, Serializable {
    private String name;
    private String age;
    private int high;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                age.equals(user.age);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
