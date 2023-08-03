package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProvinceRepos extends JpaRepository<Province,Integer> {
    @Query("SELECT b from Province b where b.id = :id")
    Province findProvinceById(@Param("id") int id);
}
