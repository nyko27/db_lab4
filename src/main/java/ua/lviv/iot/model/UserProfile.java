package ua.lviv.iot.model;

public class UserProfile {

    private Integer id;
    private String userName;
    private String surName;

    public UserProfile(Integer id, String userName, String surName) {
        this.id = id;
        this.userName = userName;
        this.surName = surName;
    }

    public UserProfile(String userName, String surName) {
        this(null, userName, surName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "\nUserProfile: " +
                "id:" + id +
                ", userName: " + userName +
                ", surName:" + surName;
    }
}
