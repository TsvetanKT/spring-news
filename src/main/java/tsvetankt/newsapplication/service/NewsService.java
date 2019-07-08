package tsvetankt.newsapplication.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tsvetankt.newsapplication.dao.entity.NewsArticle;
import tsvetankt.newsapplication.dao.repository.NewsRepository;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public List<NewsArticle> getNewsArticles(String title, Date date, Pageable pageable) {
        return newsRepository.findByDateAndTitle(date, title);
    }

    public List<NewsArticle> getAllNewsArticles() {
        return newsRepository.findAll();
    }

    public List<NewsArticle> getNewsArticles(Pageable pageable) {
        return newsRepository.findAll(pageable).getContent();
    }

    public List<NewsArticle> findByDateAndTitle(Date date, String title, Pageable pageable) {
        return newsRepository.findByDateAndTitle(date, title, pageable);
    }
}
