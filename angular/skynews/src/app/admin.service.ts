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
export class AdminService {

  blockAnalystURL = environment.serviceUrlPrefix + '/user/block';
  searchEmailById = environment.serviceUrlPrefix + '/user/search/';

  constructor(private http: HttpClient) { }


  findByEmailId(emailId): Observable<any> {
    return this.http.get(this.searchEmailById + emailId);
  }
  blockAnalyst(userData): Observable<any> {
    return this.http.post(this.blockAnalystURL, userData, httpOptions);
  }

}
