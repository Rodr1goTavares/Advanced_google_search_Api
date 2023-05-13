package com.hacking.search.sh_application.controllers;

import com.hacking.search.sh_application.models.Result;
import com.hacking.search.sh_application.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @PostMapping("/search")
    public ResponseEntity<List<Result>> makeSearch(@RequestBody String query) {
        try {
            return ResponseEntity.ok(SearchService.getResultList(query));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
