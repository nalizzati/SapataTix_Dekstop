package com.example.sapatatix.Model;

public class EventBanner {
    private int id;
    private String bannerImagePath;

    public EventBanner(int id, String bannerImagePath) {
        this.id = id;
        this.bannerImagePath = bannerImagePath;
    }

    public EventBanner(String bannerImagePath) {
        this.bannerImagePath = bannerImagePath;
    }

    public int getId() {
        return id;
    }

    public String getBannerImagePath() {
        return bannerImagePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBannerImagePath(String bannerImagePath) {
        this.bannerImagePath = bannerImagePath;
    }
}