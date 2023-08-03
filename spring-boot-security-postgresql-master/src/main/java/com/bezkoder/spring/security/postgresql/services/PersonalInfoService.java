package com.bezkoder.spring.security.postgresql.services;

import com.bezkoder.spring.security.postgresql.models.PersonalInfo;
import com.bezkoder.spring.security.postgresql.repository.PersonalInfoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonalInfoService {
    @Autowired
    PersonalInfoRepos personalInfoRepos;

    public List<PersonalInfo> getPersonalInfo() {
        return personalInfoRepos.findAllRecordsInDescendingOrder();
    }
    public PersonalInfo createPersonalInfo(PersonalInfo personalInfo) {
        return personalInfoRepos.save(personalInfo);
    }
    public void DeletePersonalInfo(int id) {
        personalInfoRepos.deleteById(id);
    }
    public PersonalInfo findPersonalInfoId(int categoryId) {
        try {
            return personalInfoRepos.findPersonalInfoById(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PersonalInfo updatePersonalInfo(PersonalInfo personalInfo) {
        int personalInfoId = personalInfo.getId();
        try {
            PersonalInfo updatePersonalInfo = personalInfoRepos.findPersonalInfoById(personalInfoId);
            if (updatePersonalInfo != null) {
                updatePersonalInfo = personalInfo;
                return personalInfoRepos.save(personalInfo);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
