package com.bezkoder.spring.security.postgresql.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class CrAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    public int getId() {
        return id;
    }
    private String name;
    private Date create_At;
    private Date update_At;
    @PrePersist
    protected void onCreate(){
        this.create_At = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.update_At = new Date();
    }

}
