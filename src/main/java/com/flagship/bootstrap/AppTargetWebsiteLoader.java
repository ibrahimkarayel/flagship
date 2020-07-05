package com.flagship.bootstrap;


import com.flagship.model.parser.TargetWebsite;
import com.flagship.repository.TargetWebsiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(0)
public class AppTargetWebsiteLoader implements CommandLineRunner {

  private Logger LOGGER = LoggerFactory.getLogger(AppTargetWebsiteLoader.class);

  private final TargetWebsiteRepository targetWebsiteRepository;

  public AppTargetWebsiteLoader(TargetWebsiteRepository targetWebsiteRepository) {
    this.targetWebsiteRepository = targetWebsiteRepository;
  }

  @Override
  public void run(String... args) {
    TargetWebsite targetWebsite = new TargetWebsite();
    targetWebsite.setUrl("https://www.gsmarena.com/huawei_p40-10153.php#");
    targetWebsiteRepository.save(targetWebsite);
    List<TargetWebsite> targetWebsites = targetWebsiteRepository.findAll();
    System.out.println(targetWebsites.size());

  }
}
