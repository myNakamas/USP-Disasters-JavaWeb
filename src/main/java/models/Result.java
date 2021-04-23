package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.entities.Disaster;

import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    String id;
    String relevance;
    String title;
    String description;
    String category;
    Date start;
    Date end;
    Date predicted_end;
    Date updated;
    Date first_seen;
    String timezone;
    int duration;
    int rank;
    int local_rank;
    int aviation_rank;
    String country;
    ArrayList<Double> location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getPredicted_end() {
        return predicted_end;
    }

    public void setPredicted_end(Date predicted_end) {
        this.predicted_end = predicted_end;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getFirst_seen() {
        return first_seen;
    }

    public void setFirst_seen(Date first_seen) {
        this.first_seen = first_seen;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getLocal_rank() {
        return local_rank;
    }

    public void setLocal_rank(int local_rank) {
        this.local_rank = local_rank;
    }

    public int getAviation_rank() {
        return aviation_rank;
    }

    public void setAviation_rank(int aviation_rank) {
        this.aviation_rank = aviation_rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<Double> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<Double> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ",\n relevance='" + relevance + '\'' +
                ",\n title='" + title + '\'' +
                ",\n description='" + description + '\'' +
                ",\n category='" + category + '\'' +
                ",\n start=" + start +
                ",\n end=" + end +
                ",\n predicted_end=" + predicted_end +
                ",\n updated=" + updated +
                ",\n first_seen=" + first_seen +
                ",\n timezone='" + timezone + '\'' +
                ",\n duration=" + duration +
                ",\n rank=" + rank +
                ",\n local_rank=" + local_rank +
                ",\n aviation_rank=" + aviation_rank +
                ",\n country='" + country + '\'' +
                ",\n location=" + location +
                '}';
    }
}
