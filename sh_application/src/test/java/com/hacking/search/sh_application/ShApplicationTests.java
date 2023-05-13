package com.hacking.search.sh_application;

import com.hacking.search.sh_application.models.Result;
import com.hacking.search.sh_application.models.Search;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShApplicationTests {

	@Test
	void contextLoads() {
		try {
			Search search = new Search ("minecraft");
			List<Result> resultList = search.getLinks();
			for (Result result : resultList) {
				String resultString = "----------"
						+ "\nTitle: " + result.getTitle()
						+ "\nUrl: " + result.getUrl();
				System.out.println(resultString);
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
