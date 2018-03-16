package ar.com.wolox.android.training.ui.network.entities;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class NewsResponse implements Serializable{
    @SerializedName("id") private Integer id;
    @SerializedName("userId") private Integer userId;
    @SerializedName("createdAt") private String createdAt;
    @SerializedName("title") private String title;
    @SerializedName("text") private String text;
    @SerializedName("likes") private List<Integer> likes;
    @SerializedName("picture") private String picture;

    public NewsResponse() {
    }

    public NewsResponse(Integer id, Integer userId, String createdAt, String title, String text, List<Integer> likes, String picture) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.title = title;
        this.text = text;
        this.likes = likes;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getLikes() {
        return likes;
    }

    public void setLikes(List<Integer> likes) {
        this.likes = likes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
