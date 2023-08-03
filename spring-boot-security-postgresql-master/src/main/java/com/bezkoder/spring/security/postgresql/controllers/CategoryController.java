package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.Category;
import com.bezkoder.spring.security.postgresql.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> getAllCategory() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All bookCategories list");
        resMap.put("data", categoryService.getCategory());
        return ResponseEntity.ok(resMap);

    }

    @PostMapping("/categories")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> createBookCategories( @RequestBody Category category) {
        Category createCategory = categoryService.createCategory(category);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All bookCategories list");
        resMap.put("data", createCategory);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/categories/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> updateBookCategories(@RequestBody Category category) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update bookCategories ");
        resMap.put("data", categoryService.updateCategory(category));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/categories/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private void deleteCategory(@PathVariable("id") int id) {
        categoryService.DeleteBookCategory(id);
    }

    @GetMapping("/categories/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> findCategoriesById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "bookCategories By Id");
        resMap.put("data", categoryService.findCategoryId(id));
        return ResponseEntity.ok(resMap);
    }
}
