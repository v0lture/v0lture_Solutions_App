package com.apps.v0lture.v0lture_solutions;

/**
 * Created by De'Angelo Grant on 5/25/2017.
 */
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

//[START issues_class]
@IgnoreExtraProperties
public class Issues {
    public String title;
    public String Description;
    public String Status;
    public String Project;
    public String Author;
    public String Time;
    public int startCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Issues(){

    }
    public Issues(String title, String Description, String Status, String Project, String Author, String Time){
        this.title = title;
        this.Description = Description;
        this.Status = Status;
        this.Project = Project;
        this.Author = Author;
        this.Time = Time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    //[START issues_to_map]
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("text", Description);
        result.put("state", Status);
        result.put("project", Project);
        result.put("display", Author);
        result.put("time", Time);

        return result;
    }
    //[END issues_to_map]
}
//END[issues_class]
