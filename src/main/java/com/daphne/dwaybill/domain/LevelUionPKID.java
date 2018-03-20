package com.daphne.dwaybill.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LevelUionPKID implements Serializable{

    @Column(name ="ACTIVITY_TYPE")
    private String activityType;

    @Column(name ="LEVEL_NO")
    private String levelNo;

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(String levelNo) {
        this.levelNo = levelNo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LevelUionPKID){
            LevelUionPKID pk = (LevelUionPKID) obj;
            if (this.activityType.equals(pk.activityType) && this.levelNo.equals(pk.levelNo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
