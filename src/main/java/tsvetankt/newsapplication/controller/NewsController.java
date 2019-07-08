package tsvetankt.newsapplication.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tsvetankt.newsapplication.dao.entity.NewsArticle;
import tsvetankt.newsapplication.service.NewsService;

@RestController
@Api(value = "News REST API")
@RequestMapping("/api")
public class NewsController {

    @Autowired
    NewsService newsService;

    @ApiOperation(value = "Get News", response = Iterable.class)
    @RequestMapping(value = "/getNews", method = RequestMethod.GET, produces = "application/json")
    public List<NewsArticle> getNews(Pageable pageable) {
        return newsService.getNewsArticles(pageable);
    }

    @ApiOperation(value = "Get News", response = Iterable.class)
    @RequestMapping(value = "/getNewsArticles", method = RequestMethod.GET,
            produces = "application/json")
    public List<NewsArticle> getNewsArticles(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "date", required = false) Date date, Pageable pageable) {

        return newsService.findByDateAndTitle(date, title, pageable);
    }
}
