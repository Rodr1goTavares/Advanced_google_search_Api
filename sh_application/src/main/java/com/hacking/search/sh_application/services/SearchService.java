package com.hacking.search.sh_application.services;

import com.hacking.search.sh_application.models.Result;
import com.hacking.search.sh_application.models.Search;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchService {
    public static List<Result> getResultList(String query) throws Exception {
        return new Search(query).getLinks();
    }
}
