package com.daphne.dwaybill.repository;

import com.daphne.dwaybill.domain.DposActivityLevel;
import com.daphne.dwaybill.domain.LevelUionPKID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DposActivityLevelRepository extends JpaRepository<DposActivityLevel,LevelUionPKID> {

}
