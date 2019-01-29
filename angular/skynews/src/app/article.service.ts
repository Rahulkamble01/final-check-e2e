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

  constructor(private http: HttpClient) { }



  markFavourite(articleData): Observable<any> {
    return this.http.post(this.addArticleUrl, articleData, httpOptions);
  }

}
