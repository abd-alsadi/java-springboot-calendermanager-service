package com.core.calendermanagerservice.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "events")
public class EventModel implements Serializable {
    public static final String TableName="events";

    @Id
    @Column(name = "id")
    private UUID  id;

    @Column(name = "title",nullable=false)
    private String title;

    @Column(name = "_from",nullable=true)
    private String from;

    @Column(name = "_to",nullable=true)
    private String to;

    @Column(name = "description",nullable=true)
    private String description;
    
    @Column(name = "location",nullable=true)
    private String location;

    @Column(name = "color",nullable=true)
    private String color;

    @Column(name = "colorText",nullable=true)
    private String colorText;

    @Column(name = "colorBorder",nullable=true)
    private String colorBorder;

    @Column(name = "isAllDay",nullable=true)
    private boolean isAllDay;

    @Column(name = "repeatEvery",nullable=true)
    private int repeatEvery;

    @Column(name = "repeatEveryExcludeDays",nullable=true)
    private String repeatEveryExcludeDays;

    @Column(name = "created",nullable=true)
    private String created;

    @Column(name = "organizerName",nullable=true)
    private String organizerName;

    @Column(name = "organizerEmailAddress",nullable=true)
    private String organizerEmailAddress;

    @Column(name = "_group",nullable=true)
    private String group;

    @Column(name = "url",nullable=true)
    private String url;

    @Column(name = "repeatEveryCustomType",nullable=true)
    private int repeatEveryCustomType;

    @Column(name = "repeatEveryCustomValue",nullable=true)
    private int repeatEveryCustomValue;

    @Column(name = "lastUpdated",nullable=true)
    private String lastUpdated;

    @Column(name = "showAlerts",nullable=true)
    private boolean showAlerts;

    @Column(name = "locked",nullable=true)
    private boolean locked;

    @Column(name = "owner",nullable=false)
    private String owner;

    @Column(name = "flag",nullable=true)
    private int flag;

    @Column(name = "createdAt",nullable=false)
    private String createdAt;

    @Column(name = "updatedAt",nullable=false)
    private String updatedAt;

}
