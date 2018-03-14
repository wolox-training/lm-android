package ar.com.wolox.android.training.ui.network.entities;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.lang.reflect.Array;

public class NewsResponse implements Serializable{
    @SerializedName("id") private Integer id;
    @SerializedName("userId") private Integer userId;
    @SerializedName("createdAt") private DateTime createdAt;
    @SerializedName("title") private String title;
    @SerializedName("text") private String text;
    @SerializedName("likes") private Array likes;
    @SerializedName("picture") private String picture;

    public Integer getId(){ return id;}

    public void setId(Integer id){ this.id = id;}

    public Integer getUserId(){ return userId;}

    public void setUserId(Integer userId){ this.userId = userId;}

    public DateTime getCreatedAt(){ return createdAt;}

    public void setCreatedAt(DateTime createdAt){ this.createdAt = createdAt;}

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}

    public String getText(){return text;}

    public void setText(String title){this.text = text;}

    public Array getLikes(){ return likes;}

    public void setLikes(Array likes){this.likes = likes;}

    public String getPicture(){ return picture;}

    public void setPicture(){ this.picture = picture;}

}
