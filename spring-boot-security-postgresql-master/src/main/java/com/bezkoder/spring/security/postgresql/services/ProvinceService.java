package com.bezkoder.spring.security.postgresql.services;

import com.bezkoder.spring.security.postgresql.models.Province;
import com.bezkoder.spring.security.postgresql.repository.ProvinceRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    ProvinceRepos provinceRepos;

    public Province createProvince(Province province) {
        return provinceRepos.save(province);
    }

    public List<Province> getProvince() {
        return provinceRepos.findAll();
    }

    public void DeleteProvince(int id) {
        provinceRepos.deleteById(id);
    }

    public Province updateProvince(Province province) {
        int categoryId;
        categoryId = province.getId();
        try {
            Province updateProvince = provinceRepos.findProvinceById(categoryId);
            if (updateProvince != null) {
                updateProvince = province;
                return provinceRepos.save(province);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public Province findProvinceId(int categoryId) {
        try {
            return provinceRepos.getById(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
