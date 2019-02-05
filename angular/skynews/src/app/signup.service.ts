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
export class SignupService {

  addUserUrl = environment.serviceUrlPrefix + '/user/signup';
  languageUrl = environment.serviceUrlPrefix + '/language/list';

  constructor(private http: HttpClient) { }



  addUser(userData): Observable<any> {
    return this.http.post(this.addUserUrl, userData, httpOptions);
  }

  getallLanguages(): Observable<any> {
    return this.http.get(this.languageUrl);
  }
}
