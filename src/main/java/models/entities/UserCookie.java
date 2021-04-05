package models.entities;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name="userCookie")
public class UserCookie {
    @Id
    @Column(name = "cookie_id", unique = true, nullable = false)
    private long cookie_id;

    @ManyToOne(fetch= FetchType.EAGER,cascade = {CascadeType.DETACH,CascadeType.PERSIST})
    @JoinColumn(name = "userId")    //not sure about this
    private User user;

    @Column(name = "cookie_ttl", nullable = false)
    private String cookieTitle;

    @Column(name = "ipAddress", nullable = false)
    private String ip_address;

    public UserCookie() {
        Random rand = new Random();
        //generate the cookie id
        cookie_id = rand.nextLong();
    }
    public UserCookie(User user, String title, String ip_address) {
        Random rand = new Random();
        //generate the cookie id
        cookie_id = rand.nextLong();
        this.user=user;
        this.cookieTitle=title;
        this.ip_address=ip_address;
    }

    public long getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(long cookie_id) {
        this.cookie_id = cookie_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCookieTitle() {
        return cookieTitle;
    }

    public void setCookieTitle(String cookieTitle) {
        this.cookieTitle = cookieTitle;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
