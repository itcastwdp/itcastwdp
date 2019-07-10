package cn.itcast.domain;

import java.util.Date;

public class Users {
    int uid;
    String userName;
    private Date birthday;
    private char gender;
    private String uaddress;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", uaddress='" + uaddress + '\'' +
                '}';
    }
}
