package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.PersonalInfo;
import com.bezkoder.spring.security.postgresql.services.PersonalInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api")
public class PersonalInfoController {
    @Autowired
    PersonalInfoService personalInfoService;

    @GetMapping("/personaInfo")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> getAllPersonaInfo() {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All personaInfo list");
        resMap.put("data", personalInfoService.getPersonalInfo());
        return ResponseEntity.ok(resMap);

    }
    @PostMapping("/personaInfo")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createPersonalInfo(@Valid @RequestBody PersonalInfo personalInfo) {
        PersonalInfo createPersonalInfo = personalInfoService.createPersonalInfo(personalInfo);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "All personalInfo list");
        resMap.put("data", createPersonalInfo);
        return ResponseEntity.ok(resMap);
    }

    @PutMapping("/personaInfo/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> updatePersonaInfo(@RequestBody PersonalInfo personalInfo) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "update personaInfo ");
        resMap.put("data", personalInfoService.updatePersonalInfo(personalInfo));
        return ResponseEntity.ok(resMap);
    }

    @DeleteMapping("/personaInfo/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    private void deletePersonaInfo(@PathVariable("id") int id) {
        personalInfoService.DeletePersonalInfo(id);
    }

    @GetMapping("/personaInfo/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HashMap<String, Object>> findLibraryPersonaInfoById(@PathVariable("id") int id) {
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("success", true);
        resMap.put("responseCode", 200);
        resMap.put("message", "LibraryMembers By Id");
        resMap.put("data", personalInfoService.findPersonalInfoId(id));
        return ResponseEntity.ok(resMap);
    }



}
