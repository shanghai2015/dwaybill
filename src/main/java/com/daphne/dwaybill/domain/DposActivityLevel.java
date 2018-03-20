package com.daphne.dwaybill.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="DPOS_ACTIVITY_LEVEL")
public class DposActivityLevel implements Serializable{

    @Id
    LevelUionPKID uionPKID = new LevelUionPKID();

    @Column(name ="LEVEL_NAME")
    private String levelName;;

    public LevelUionPKID getUionPKID() {
        return uionPKID;
    }

    public void setUionPKID(LevelUionPKID uionPKID) {
        this.uionPKID = uionPKID;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    ;
}
