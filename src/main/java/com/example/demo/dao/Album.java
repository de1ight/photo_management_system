package com.example.demo.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id")
    private long id;

    @Column(name = "album_name")
    private String album_name;
    @Column(name = "first_p")
    private long first_p;

    @Column(name="p_num")
    private long p_num;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public long getFirst_p() {
        return first_p;
    }

    public void setFirst_p(long first_p) {
        this.first_p = first_p;
    }

    public long getP_num() {
        return p_num;
    }

    public void setP_num(long p_num) {
        this.p_num = p_num;
    }
}
