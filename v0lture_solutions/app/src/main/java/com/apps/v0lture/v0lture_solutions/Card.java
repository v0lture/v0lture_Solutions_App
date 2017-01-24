package com.apps.v0lture.v0lture_solutions;

/**
 * Created by De'Angelo on 1/4/2017.
 */

public class Card {
    private String name;
    private String details;
    private String version;
    private int thumbnail;


    public Card(String name, String details,String version, int thumbnail){
        this.name = name;
        this.details = details;
        this.version= version;
        this.thumbnail=thumbnail;

    }
    public String getName(){
        return name;
    }
    public void  setName(String name){
        this.name = name;
    }
    public String getDetails(){
        return details;
    }
    public void setDetails(String details){
        this.details = details;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
