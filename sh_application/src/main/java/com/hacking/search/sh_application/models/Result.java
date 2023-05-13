package com.hacking.search.sh_application.models;

import java.util.HashMap;

public class Result {
    private String title;
    private String url;

    public Result() {}

    public Result(String title, String url, String description) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> toHashMap() {
        HashMap<String, String> resultHashMap = new HashMap<>();
        resultHashMap.put("title", this.title);
        resultHashMap.put("url", this.url);
        return resultHashMap;
    }
}
