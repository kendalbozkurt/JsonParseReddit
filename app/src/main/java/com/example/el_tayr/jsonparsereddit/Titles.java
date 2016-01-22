package com.example.el_tayr.jsonparsereddit;

/**
 * Created by El-tayr on 21.01.2016.
 */
public class Titles {

    private String title;
    private String url;

    public Titles(String title,String url){
        super();
        this.title=title;
        this.url=url;
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
}
