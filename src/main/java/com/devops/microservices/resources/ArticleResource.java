package com.devops.microservices.resources;

import com.iut.Article;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;





@Controller
@RequestMapping(value = "/article")

public class ArticleResource {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ArticleResource.class);

    ArrayList <Article>  articles;
    @PostConstruct
    public void init() {
        articles = new ArrayList<Article>();
        Article article = new Article();
        article.setId(1);
        article.setNom("Nu");
        articles.add(article);

         article = new Article();
        article.setId(2);
        article.setNom("TELLA");
        articles.add(article);


    }


    @GetMapping()
    public ResponseEntity<List<Article>> articles() {
        logger.info(" liste article ");
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Article> article(@PathVariable("id") int id) {
        logger.info(" article ");
        Article art = articles.stream().filter(article -> id == article.getId()) .findAny()
                .orElse(null);
        return new ResponseEntity<Article>(art, HttpStatus.OK);
    }

    @GetMapping("{id}/{name}")
    public ResponseEntity<Article> getArticleByIdByName(@PathVariable("id") int id, @PathVariable("name") String name) {
        logger.info(" article ");
        Article art = articles.stream().filter(article -> id == article.getId() &&
                        name.equals(article.getNom()))
                .findAny()
                .orElse(null);
        return new ResponseEntity<Article>(art, HttpStatus.OK);
    }





}
