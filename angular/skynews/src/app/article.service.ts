import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from './environment';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
    }
  )
};
@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  addArticleUrl = environment.serviceUrlPrefix + '/article/save';
  fetchfavArticleUrl = environment.serviceUrlPrefix + '/article/fetchfavArticle/';

  constructor(private http: HttpClient) { }

  markFavourite(articleData): Observable<any> {
    return this.http.post(this.addArticleUrl, articleData, httpOptions);
  }


  getFavArticles(emailId): Observable<any> {
    return this.http.get(this.fetchfavArticleUrl + emailId);
  }



}
