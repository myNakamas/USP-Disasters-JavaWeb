package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    ArrayList<Result> results;


    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }
}
