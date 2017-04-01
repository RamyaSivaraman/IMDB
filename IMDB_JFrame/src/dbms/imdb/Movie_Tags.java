package dbms.imdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramya Sivaraman
 */
public class Movie_Tags {
    int tag_id;
    int movie_id;
    int tag_weight;

 
    public Movie_Tags() {

    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getTag_weight() {
        return tag_weight;
    }

    public void setTag_weight(int tag_weight) {
        this.tag_weight = tag_weight;
    }
    
    
    
    
    
    
}
