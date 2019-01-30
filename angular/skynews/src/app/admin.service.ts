import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from './environment'
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

  blockAnalystURL = environment.serviceUrlPrefix + '/admin/block';

  constructor(private http: HttpClient) { }



  blockAnalyst(emailId): Observable<any> {
    return this.http.get(this.blockAnalystURL);
  }

}
