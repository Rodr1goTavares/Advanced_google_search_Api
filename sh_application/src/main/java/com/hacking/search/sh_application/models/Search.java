package com.hacking.search.sh_application.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Search {
    private String query;
    private String url;
    private Document doc;

    public Search(String query) throws IOException {
        this.query = query;
        this.url = "https://www.google.com/search?q=intext:" + this.query;
        this.doc = Jsoup.connect(url).get();
    }

    public List<Result> getLinks() {
        List<Result> resultLinksList = new ArrayList<>();
        
        Elements searchResults = this.doc.select("div.g");

        for (Element result : searchResults) {
            Element resultLink = result.selectFirst("a");
                
            String title = resultLink.text();
            String resultUrl = resultLink.attr("href");
            String description = resultLink.selectXpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[7]/div/div/div[2]/div/span").text();

            if (url.startsWith("/url?q=")) {
                this.url = url.substring(7);
            }

            Result resultObj = new Result();
            resultObj.setTitle(title);
            resultObj.setUrl(resultUrl);
            resultObj.setDescription(description);
            resultLinksList.add(resultObj);
        } 
        return resultLinksList;
    }
}
