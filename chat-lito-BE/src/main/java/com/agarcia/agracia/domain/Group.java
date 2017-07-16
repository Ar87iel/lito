package com.agarcia.agracia.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lito on 15/7/17.
 */

@Entity
@Table (name = "Groups")
public class Group {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User owner;


    private String name;
    private String logo;
    private Date creationg_date;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setCreationg_date(Date creationg_date) {
        this.creationg_date = creationg_date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public Date getCreationg_date() {
        return creationg_date;
    }
}


