import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { AuthService } from '../auth.service';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  // b6bfe2b91aa3400b9cc2bfe02a54bb08
  articlesResult: any;
  searchArticlesResult: any;
  markedFavourite: boolean;
  mode: string;
  favoriteArticleStatus: any = [];
  searchFavoriteArticleStatus: any = [];
  languageCode: any;
  authenticationData: any;
  userData: any;
  emailId: any;
  searchedKeyWord: string;


  constructor(private articleService: ArticleService, private service: AuthService) { }

  ngOnInit() {

    //  this.languageCode = this.service.getLanguageCode();
    this.authenticationData = JSON.parse(sessionStorage.getItem('currentUser'));
    this.userData = this.authenticationData.actualUser;
    this.emailId = this.userData.email;
    this.languageCode = this.userData.language.code;
    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('b6bfe2b91aa3400b9cc2bfe02a54bb08');
    // To query /v2/top-headlines
    // All options passed to topHeadlines are optional, but you need to include at least one of them
    this.mode = 'headlines';
    newsapi.v2.topHeadlines({
      // sources: 'bbc-news',
      language: this.languageCode,
      // sortBy: 'relevancy',
    }).then(response => {

      console.log(response);
      this.articlesResult = response.articles;
      for (let i = 0; i <= this.articlesResult.length; i++) {
        this.favoriteArticleStatus.push(0);
      }
    });
  }

  addmarkFavourite(article, index) {
    article['email'] = this.emailId;
    console.log(article);
    console.log(JSON.stringify(article));
    this.articleService.markFavourite(article).subscribe(data => {
      console.log(data);
      this.markedFavourite = data.markedFavourite;
      console.log(this.mode);
      if (this.markedFavourite && this.mode === 'headlines') {
        this.favoriteArticleStatus[index] = 1;
      }
      if (this.markedFavourite && this.mode === 'search') {
        console.log('inside marking fav');
        this.searchFavoriteArticleStatus[index] = 1;
      }
      // console.log(this.favoriteArticleStatus[index]);
    });
  }

  markedFavouriteStatus(index) {
    return this.favoriteArticleStatus[index] ? 'fas fa-heart favourite-marked' : 'far fa-heart favourite-unmarked';
  }

  searchmarkedFavouriteStatus(index) {
    return this.searchFavoriteArticleStatus[index] ? 'fas fa-heart favourite-marked' : 'far fa-heart favourite-unmarked';
  }

  SearchNews(keyword) {
    this.mode = 'search';
    this.searchedKeyWord = keyword;
    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('b6bfe2b91aa3400b9cc2bfe02a54bb08');

    newsapi.v2.everything({
      q: keyword,
      // sources: 'bbc-news',
      language: this.languageCode,
      sortBy: 'relevancy',
    }).then(response => {
      console.log(response);
      this.searchArticlesResult = response.articles;
      this.searchFavoriteArticleStatus = [];
      for (let i = 0; i <= this.searchArticlesResult.length; i++) {
        this.searchFavoriteArticleStatus.push(0);
      }
    });

  }
}
