import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  // b6bfe2b91aa3400b9cc2bfe02a54bb08
  articlesResult: any;


  constructor(private articleService: ArticleService) { }

  ngOnInit() {
    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('b6bfe2b91aa3400b9cc2bfe02a54bb08');
    // To query /v2/top-headlines
    // All options passed to topHeadlines are optional, but you need to include at least one of them
    newsapi.v2.everything({
      q: 'china',
      sources: 'bbc-news',
      language: 'en',
      sortBy: 'relevancy',
      page: 2
    }).then(response => {
      console.log(response);
      this.articlesResult = response.articles;
      /*
        {
          status: "ok",
          articles: [...]
        }
      */
    });
  }
  markFavourite(article) {

    if (2 > 0) {
      return 'far fa-heart favourite-unmarked';
    } else {
      return 'fas fa-heart favourite-marked';
    }
  }
  addmarkFavourite(article) {
    article['email'] = 'abc@gmail.com';
    console.log(article);
    this.articleService.markFavourite(article).subscribe(data => {
      console.log(data);
    });
  }
}
