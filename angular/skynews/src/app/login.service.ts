import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
export class LoginService {

  genereateTokenUrl = environment.serviceUrlPrefix + '/token';
  userLoginUrl = environment.serviceUrlPrefix + '/user/login';

  constructor(private http: HttpClient) { }


  generateToken(tokenData): Observable<any> {
    return this.http.post(this.genereateTokenUrl, tokenData, httpOptions);
  }

  loginUser(userData): Observable<any> {
    return this.http.post(this.userLoginUrl, userData, httpOptions);
  }
}
