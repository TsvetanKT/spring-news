package tsvetankt.newsapplication.dao.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tsvetankt.newsapplication.dao.entity.NewsArticle;

@Repository
public interface NewsRepository extends PagingAndSortingRepository<NewsArticle, Integer>{
   
    public List<NewsArticle> findByDateAndTitle(Date date, String title);
    
    public List<NewsArticle> findAll();
    
    @Query("SELECT " + 
            "  n " + 
            "FROM " + 
            "  NewsArticle n " + 
            "WHERE" + 
            "  ( " + 
            "    ?1 IS NULL " + 
            "    OR ((SUBSTR(n.date, 1, 10) = SUBSTR(?1, 1, 10)) " + 
            "      AND (SUBSTR(n.date, 1, 10) = SUBSTR(?1, 1, 10)) " + 
            "      AND (SUBSTR(n.date, 1, 10) = SUBSTR(?1, 1, 10)) " + 
            "    ) " + 
            "  ) " + 
            "  AND (" + 
            "    ?2 IS NULL " + 
            "    OR n.title LIKE CONCAT('%', ?2, '%')) ")
        public List<NewsArticle> findByDateAndTitle(
                Date date, 
                String title,
                Pageable pageable);
    
}
