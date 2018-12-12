package org.bryan95.taekyulee;

import java.util.Date;

public class FoodInfo {
    //public String Movieposter;//drawableId
    public String MovieName;//price
    public int userrating;//평점
    //public String pubdate;//날짜
    public String director;
    public String actor;


    public FoodInfo( String MovieName, String director, String actor){
        //this.Movieposter = Movieposter;
        this.MovieName = MovieName;
        //this.userrating=userrating;
        //this.pubdate=pubdate;
        this.director=director;
        this.actor=actor;
    }
}
