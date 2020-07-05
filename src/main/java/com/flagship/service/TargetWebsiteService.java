package com.flagship.service;

import com.flagship.model.parser.TargetWebsite;
import com.flagship.repository.TargetWebsiteRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class TargetWebsiteService {

  private final TargetWebsiteRepository targetWebsiteRepository;

  public TargetWebsiteService(TargetWebsiteRepository targetWebsiteRepository) {
    this.targetWebsiteRepository = targetWebsiteRepository;
  }

  public List<TargetWebsite> findAll() {
    return targetWebsiteRepository.findAll();
  }

  public TargetWebsite save(TargetWebsite targetWebsite) {
    return targetWebsiteRepository.save(targetWebsite);
  }

}
