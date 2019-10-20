package com.hokumus.course.model.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.course.model.utils.BaseEntity;

@Entity
@Table(name = "group_day")
public class GroupDays extends BaseEntity{

    private Long id;
    private Groups Groups;
    private Days Days;

    @Id
    @SequenceGenerator(name = "seq_group_day", allocationSize = 1, sequenceName = "seq_group_day")
    @GeneratedValue(generator = "seq_group_day", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Groups getGroups() {
        return Groups;
    }

    public void setGroups(Groups Groups) {
        this.Groups = Groups;
    }

    @ManyToOne
    @JoinColumn(name = "days_id")
    public Days getDays() {
        return Days;
    }

    public void setDays(Days Days) {
        this.Days = Days;
    }

}

