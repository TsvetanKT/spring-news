spring-news
=================
Simple REST API for search / sort news articles saved in db

### Uses
* 	Spring Boot 2.1.4
*	API Documentation with Swagger 2.9.2
*	ORM with Hibernate
*	hsqldb DB

### Endpoints examples:
*	**GET** http://localhost:8080/api/getNewsArticles?title=title&date=2019-07-05&sort=date&sort=title,desc
	<br/>Explanation - search all articles with name containing "title" from date '2019-07-05', sorted by 
	date and then by title descending

*	**GET** http://localhost:8080/api/getNews
	<br/>Shows all news
	
*	**POST** http://localhost:8080/api/article
	<br/>Create new article
	
### Swagger endpoint - UI
*	http://localhost:8080/swagger-ui.html