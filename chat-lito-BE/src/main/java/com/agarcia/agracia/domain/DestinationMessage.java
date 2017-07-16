package com.agarcia.agracia.domain;

import javax.persistence.*;

/**
 * Created by lito on 15/7/17.
 */

@Entity
public class DestinationMessage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Message message;
    @ManyToOne
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Message getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
