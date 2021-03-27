package flagcamp.authdeal.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

  private static final long serialVersionUID = 2681531852204068105L;

  @Id
  private String userName;
  private String password;
  private boolean enabled;
  private float rate;
  private String picture;
  private String phoneNum;

  public Users() {
  }

  public Users(String userName, String password, boolean enabled, float rate,
      String picture, String phoneNum) {
    this.userName = userName;
    this.password = password;
    this.enabled = enabled;
    this.rate = rate;
    this.picture = picture;
    this.phoneNum = phoneNum;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public float getRate() {
    return rate;
  }

  public void setRate(float rate) {
    this.rate = rate;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Users)) {
      return false;
    }
    Users users = (Users) o;
    return isEnabled() == users.isEnabled() &&
        Float.compare(users.getRate(), getRate()) == 0 &&
        Objects.equals(getUserName(), users.getUserName()) &&
        Objects.equals(getPassword(), users.getPassword()) &&
        Objects.equals(getPicture(), users.getPicture()) &&
        Objects.equals(getPhoneNum(), users.getPhoneNum());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getUserName(), getPassword(), isEnabled(), getRate(), getPicture(), getPhoneNum());
  }

  @Override
  public String toString() {
    return "Users{" +
        "userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", enabled=" + enabled +
        ", rate=" + rate +
        ", picture='" + picture + '\'' +
        ", phoneNum='" + phoneNum + '\'' +
        '}';
  }
}
