package com.flagship.controller;

import com.flagship.service.WebScraperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RssFeedController {

    private final WebScraperService webScraperService;

    public RssFeedController(WebScraperService webScraperService) {
        this.webScraperService = webScraperService;
    }

    @GetMapping("/scrap")
    @ResponseBody
    public void scrap() {
        webScraperService.scrapAndSave();
    }

}
