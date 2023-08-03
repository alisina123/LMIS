package com.bezkoder.spring.security.postgresql.services;

import com.bezkoder.spring.security.postgresql.models.Category;
import com.bezkoder.spring.security.postgresql.repository.CategoryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepos categoryRepos;

    public Category createCategory(Category category) {
        return categoryRepos.save(category);
    }

    public List<Category> getCategory() {
        return categoryRepos.findAll();
    }

    public void DeleteBookCategory(int id) {
        categoryRepos.deleteById(id);
    }

    public Category updateCategory(Category category) {
        int categoryId = category.getId();
        try {
            Category updateCategory = categoryRepos.findCategoryById(categoryId);
            if (updateCategory != null) {
                updateCategory = category;
                return categoryRepos.save(category);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Category findCategoryId(int categoryId) {
        try {
            return categoryRepos.findCategoryById(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}