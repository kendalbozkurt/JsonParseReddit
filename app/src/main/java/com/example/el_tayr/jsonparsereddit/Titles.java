package com.example.el_tayr.jsonparsereddit;

/**
 * Created by El-tayr on 21.01.2016.
 */
public class Titles {

    private String title;
    private String url;
    private String blogType;
    private int ups;
    public Titles(String title,String url,String blogType,int ups){
        super();
        this.title=title;
        this.url=url;
        this.blogType=blogType;
        this.ups=ups;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public int getUps() {
        return ups;
    }
}
