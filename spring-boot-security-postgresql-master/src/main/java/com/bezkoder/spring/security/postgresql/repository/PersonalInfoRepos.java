package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalInfoRepos extends JpaRepository<PersonalInfo, Integer> {
    @Query("SELECT b from PersonalInfo b where b.id = :id")
    PersonalInfo findPersonalInfoById(@Param("id") int id);

    @Query("SELECT b FROM PersonalInfo b ORDER BY b.name ASC")
    List<PersonalInfo> findAllRecordsInDescendingOrder();

}
