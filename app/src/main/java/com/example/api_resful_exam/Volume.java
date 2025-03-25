package com.example.api_resful_exam;

public class Volume {
    private String title;
    private String cover;
    private String doi;
    private String issue_id;  // Nuevo campo

    // Constructor actualizado
    public Volume(String title, String cover, String doi, String issue_id) {
        this.title = title;
        this.cover = cover;
        this.doi = doi;
        this.issue_id = issue_id;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getDoi() {
        return doi;
    }

    // Nuevo getter para issue_id
    public String getIssue_id() {
        return issue_id;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    // Setter para issue_id
    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }
}