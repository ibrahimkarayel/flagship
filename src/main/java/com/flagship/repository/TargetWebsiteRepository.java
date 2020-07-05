package com.flagship.repository;

import com.flagship.model.parser.TargetWebsite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TargetWebsiteRepository extends CrudRepository<TargetWebsite, Long> {
    List<TargetWebsite> findAll();
}
