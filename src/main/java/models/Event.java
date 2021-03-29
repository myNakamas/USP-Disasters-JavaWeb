package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
//    String id;            I dont think we need those, its mostly nulls
//    String title;         We can extract more than 1 page at a time
//    String description;
//    int count;
//    boolean overflow;
//    String next;
//    String previous;
    ArrayList<Result> results;


    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}
