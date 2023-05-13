package com.hacking.search.sh_application.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* actual problem: The query is null
* */
public class Search {
    private String query;
    private String url;
    private Document doc;

    public Search(String query) throws IOException {
        this.query = query;
        this.url = "https://www.google.com/search?q=intext:" + this.query;
        this.doc = Jsoup.connect(url).get();
    }

    public List<Result> getLinks() throws Exception {
            List<Result> resultLinksList = new ArrayList<>();
        try {
            Elements searchResults = this.doc.select("div.g");

            for (Element result : searchResults) {
                Element resultLink = result.selectFirst("a");
                String title = resultLink.text();
                String url = resultLink.attr("href");

                if (url.startsWith("/url?q=")) {
                    this.url = url.substring(7);
                }

                Result resultObj = new Result();
                resultObj.setTitle(resultLink.text());
                resultObj.setUrl(resultLink.attr("href"));
                resultLinksList.add(resultObj);
            }
            return resultLinksList;
        }
        catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
}
