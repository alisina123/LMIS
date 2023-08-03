package com.bezkoder.spring.security.postgresql.repository;


import com.bezkoder.spring.security.postgresql.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepos extends JpaRepository<Category,Integer> {
    @Query("SELECT b from Category b where b.id = :id")
    Category findCategoryById(@Param("id") int id);
}
