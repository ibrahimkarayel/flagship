package com.flagship.service;

import com.flagship.model.parser.ParseEntryRule;
import com.flagship.model.parser.PhoneSpec;
import com.flagship.model.parser.TargetWebsite;
import com.flagship.repository.ParseEntryRuleRepository;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class WebScraperService {

  private TargetWebsiteService targetWebsiteService;
  private ParseEntryRuleRepository parseEntryRuleRepository;

  public WebScraperService(TargetWebsiteService targetWebsiteService, ParseEntryRuleRepository parseEntryRuleRepository) {
    this.targetWebsiteService = targetWebsiteService;
    this.parseEntryRuleRepository = parseEntryRuleRepository;
  }

  @SneakyThrows
  public void scrapAndSave() {
    List<TargetWebsite> websites = targetWebsiteService.findAll();
    processWebsitesScrapping(websites);
    log.info("Total: " + websites.size() + " websites scrapped.");
  }

  @SneakyThrows
  private void processWebsitesScrapping(List<TargetWebsite> websites) {
    for (TargetWebsite website : websites) {
      Document doc = Jsoup.connect(website.getUrl()).get();
      PhoneSpec phoneSpec = getTableData(doc);
      ParseEntryRule parseEntryRule = ParseEntryRule.builder().phoneSpec(phoneSpec).build();
      ParseEntryRule rule = parseEntryRuleRepository.save(parseEntryRule);
      System.out.println(rule.getId());
    }
  }

  public PhoneSpec getTableData(Document doc) {
    Element table = doc.select("table").first();
    PhoneSpec phoneSpec = new PhoneSpec();
    for (Element row : table.select("tr")) {
      Elements tds = row.select("td");
      if (tds.get(0).text().equals("Technology")) {
        phoneSpec.setTechnology(tds.get(1).text());
      } else if (tds.get(0).text().equals("2G bands")) {
        phoneSpec.setG2(tds.get(1).text());
      } else if (tds.get(0).text().equals("3G bands")) {
        phoneSpec.setG3(tds.get(1).text());
      } else if (tds.get(0).text().equals("4G bands")) {
        phoneSpec.setG4(tds.get(1).text());
      } else if (tds.get(0).text().equals("5G bands")) {
        phoneSpec.setG5(tds.get(1).text());
      } else if (tds.get(0).text().equals("Speed")) {
        phoneSpec.setSpeed(tds.get(1).text());
      }
    }
    return phoneSpec;
  }

}
