package models.entities;

import models.Result;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
@Entity
@Table(name="disaster")
public class Disaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String DisasterId;
    String relevance;
    String title;
    @Column(columnDefinition = "TEXT")
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
    String location;


        public Disaster() {
        }

    public Disaster(String title, String description,  Date start, Date end, String country, String location) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.country = country;
        this.location = location;
    }

    public Result getAsResult()
        {
            Result r = new Result();
            r.setId(DisasterId);
            r.setRelevance(relevance);
            r.setTitle(title);
            r.setDescription(description);
            r.setCategory(category);
            r.setStart(start);
            r.setEnd(end);
            r.setPredicted_end(predicted_end);
            r.setUpdated(updated);
            r.setFirst_seen(first_seen);
            r.setTimezone(timezone);
            r.setDuration(duration);
            r.setRank(rank);
            r.setLocal_rank(local_rank);
            r.setAviation_rank(aviation_rank);
            r.setCountry(country);
            r.setLocation(getLocation2());
            return r;
        }

    public Disaster(Result result) {
        this.DisasterId =result.getId();
        this.relevance = result.getRelevance();
        this.title = result.getTitle();
        this.description = result.getDescription();
        this.category = result.getCategory();
        this.start = result.getStart();
        this.end = result.getEnd();
        this.predicted_end = result.getPredicted_end();
        this.updated = result.getPredicted_end();
        this.first_seen = result.getFirst_seen();
        this.timezone = result.getTimezone();
        this.duration = result.getDuration();
        this.rank = result.getRank();
        this.local_rank = result.getLocal_rank();
        this.aviation_rank = result.getAviation_rank();
        this.country = result.getCountry();
        this.setLocation(result.getLocation());
    }

    public Disaster(String DisasterId, String relevance, String title, String description, String category, Date start, Date end, Date predicted_end, Date updated, Date first_seen, String timezone, int duration, int rank, int local_rank, int aviation_rank, String country, String location) {
        this.DisasterId = DisasterId;
        this.relevance = relevance;
        this.title = title;
        this.description = description;
        this.category = category;
        this.start = start;
        this.end = end;
        this.predicted_end = predicted_end;
        this.updated = updated;
        this.first_seen = first_seen;
        this.timezone = timezone;
        this.duration = duration;
        this.rank = rank;
        this.local_rank = local_rank;
        this.aviation_rank = aviation_rank;
        this.country = country;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisasterId() {
        return DisasterId;
    }

    public void setDisasterId(String disasterId) {
        this.DisasterId = disasterId;
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

    public ArrayList<Double> getLocation2() {
        ArrayList<Double> location2 = new ArrayList<>();
        String[] loc = location.split(",");
        location2.add(Double.parseDouble(loc[1]));
        location2.add(Double.parseDouble(loc[0]));
        return location2;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setLocation(ArrayList<Double> r){
        this.location = r.get(1)+","+r.get(0);
    }
}
