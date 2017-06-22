package com.example.am8_adam.test8;

/**
 * Created by Moh Pele on 29/04/2017.
 */

public class movie {
    private String Head;
    private String Description;
    private String imageUrl;
    private String vote_average;
    private String relase_data;
    private String id;


    public movie(String id, String description, String head, String imageUrl, String vote_average, String relase_data) {

        this.Head = head;
        this.Description = description;
        this.imageUrl=imageUrl;
        this.relase_data=relase_data;
        this.vote_average=vote_average;
        this.id=id;

    }



    public String getHead() {
        return Head;
    }

    public String getRelase_data() {
        return relase_data;
    }


    public String getVote_average() {
        return vote_average;
    }

    public void setHead(String head) {
        Head = head;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setRelase_data(String relase_data) {
        this.relase_data = relase_data;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
