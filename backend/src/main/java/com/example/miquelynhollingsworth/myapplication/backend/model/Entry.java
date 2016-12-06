package com.example.miquelynhollingsworth.myapplication.backend.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENTRY")
public class Entry {

    @Id
    @GeneratedValue
    @Column(name = "ENTRY_ID")
    private int entryId;

    @Column(name = "TEXT_ENTRY")
    private String text;

    @Column(name = "PICTURE")
    private Blob picture;

    @Column(name = "ENTRY_DATE")
    private String entryDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Entry(String text, Blob picture, String entryDate){
        this.text = text;
        this.picture = picture;
        this.entryDate = entryDate;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}
