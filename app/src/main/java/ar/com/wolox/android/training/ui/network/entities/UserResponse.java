package ar.com.wolox.android.training.ui.network.entities;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("id") private Integer id;
    @SerializedName("username") private String username;
    @SerializedName("email") private String email;
    @SerializedName("password") private String password;
    @SerializedName("picture") private String picture;
    @SerializedName("cover") private String cover;
    @SerializedName("description") private String description;
    @SerializedName("location") private String location;
    @SerializedName("name") private String name;
    @SerializedName("phone") private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


