package com.bezkoder.spring.security.postgresql.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Assuming the ID property is of type Long, you can adjust it to the appropriate type (e.g., int) if needed
    // Other properties and methods
    public int getId() {
        return id;
    }
    private String name;
    private String LastName;
    private String fatherName;
    private String identityNumber;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private  String conform;
    private String reference;
    private String cheild;
    private  String sadera;
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date sendDate;
    private String salaryOrder;
    private String serveOrder;
    private String salaryAmount;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date OrderDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private  Date havalaDate;
    private  String phone;
    private String currentAddress;
    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private ProvinceState state;
    @JoinColumn(name = "province_id")
    @ManyToOne
    private Province province;
    @ManyToOne
    private Category category;
    @JoinColumn(name="address_id")
    @ManyToOne
    private CrAddress address;
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
