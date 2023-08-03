package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.Province;
import com.bezkoder.spring.security.postgresql.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("/province")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> getAllProvince() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All personaInfo list");
        resMap.put("data", provinceService.getProvince());
        return ResponseEntity.ok(resMap);

    }
    @PostMapping("/province")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createProvince(@RequestBody Province province) {
        Province createProvince = provinceService.createProvince(province);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All personalInfo list");
        resMap.put("data", createProvince);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/province/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> updateProvince(@RequestBody Province province) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update personaInfo ");
        resMap.put("data", provinceService.updateProvince(province));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/province/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private void deleteProvince(@PathVariable("id") int id) {
        provinceService.DeleteProvince(id);
    }

    @GetMapping("/province/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> findProvinceById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "LibraryMembers By Id");
        resMap.put("data", provinceService.findProvinceId(id));
        return ResponseEntity.ok(resMap);
    }



}