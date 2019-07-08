package tsvetankt.newsapplication;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tsvetankt.newsapplication.dao.entity.NewsArticle;
import tsvetankt.newsapplication.dao.repository.NewsRepository;

@Component
public class DataInitializer {

    private final Logger LOG = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    NewsRepository newsRepository;

    public void initData() {

        try {
            List<NewsArticle> testData = getFakeData();
            newsRepository.saveAll(testData);
        } catch (final Exception ex) {
            LOG.error("Exception while inserting the mock data {}", ex);
        }
    }

    private List<NewsArticle> getFakeData() {

        List<NewsArticle> articles = new ArrayList<>();
        articles.add(new NewsArticle("2019-07-05", "Test title", "Test 1", "Test text 1"));
        articles.add(new NewsArticle("2019-07-02", "Test title2", "Test 22", "Test text 22"));
        articles.add(new NewsArticle("2019-07-08", "ccc", "Test description", "Test text"));
        articles.add(new NewsArticle("2019-07-04", "zzz", "Test 4", "Test text 4"));
        articles.add(new NewsArticle("2019-06-03", "A", "Test 5", "Test text 5"));
        articles.add(new NewsArticle("2019-07-03", "Abc", "Test 6", "Test text 6"));
        articles.add(new NewsArticle("2019-07-03", "Abcde", "Test 7", "Test text 7"));
        return articles;
    }
}
