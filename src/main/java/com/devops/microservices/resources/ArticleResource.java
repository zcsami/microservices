package com.devops.microservices.resources;

import com.iut.Article;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        article.setId((int)new Date().getTime());
        article.setNom("Process");
        articles.add(article);
         article = new Article();
        article.setId((int)new Date().getTime());
        article.setNom("dd");
        articles.add(article);


    }


    @GetMapping
    public ResponseEntity<List<Article>> articles() {
        logger.info(" liste article ");
        return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
    }





}
