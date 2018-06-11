package models;

import io.ebean.Finder;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

import java.util.Date;



/**
 * Company entity managed by Ebean
 */
@Entity 
public class User extends BaseModel {

    private static final long serialVersionUID = 1L;

    // @Constraints.Required
    // public String name;
    @Constraints.Required
    public String email;

    @Constraints.Required
    public String fullName;

    @Constraints.Required
    public String password;

    @Constraints.Required
    @Formats.DateTime(pattern="yyyy-MM-dd")
    public Date createTime;

    // @Constraints.Required
    // public boolean isAdmin = false;

    // public String phone;

    // public String address;

    // public int age;

    // public boolean isMale;

    // public String avatar;


    public static final Finder<Long, User> find = new Finder<>(User.class);

    // @Override
    // public void save() {
    //     createdAt();
    //     this.email = "chenxingyu.cs@gmail.com";
    //     this.phone = "6506607605";
    //     this.address = "Default address for testing";
    //     this.age = 25;
    //     this.isMale = true;
    //     this.avatar = "http://dummyimage.com/100x100/79c0f2/757575.png&text=1";
    //     super.save();
    // }

    @PrePersist
    void createdAt() {
        this.createTime = new Date();
    }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // public boolean isAdmin() {
    //     return isAdmin;
    // }

    // public void setAdmin(boolean admin) {
    //     isAdmin = admin;
    // }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // public String getPhone() {
    //     return phone;
    // }

    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public int getAge() {
    //     return age;
    // }

    // public void setAge(int age) {
    //     this.age = age;
    // }

    // public boolean isMale() {
    //     return isMale;
    // }

    // public void setMale(boolean male) {
    //     isMale = male;
    // }

    // public String getAvatar() {
    //     return avatar;
    // }

    // public void setAvatar(String avatar) {
    //     this.avatar = avatar;
    // }
}

