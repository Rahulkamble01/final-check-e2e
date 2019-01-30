import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userData: any;
  loggedIn = false;
  isAdmin = false;
  code: any;
  constructor(private router: Router) { }


  login(userData) {
    console.log('"Inside auth service login()"');
    this.loggedIn = true;
    if (userData.role.description === 'admin') {
      this.isAdmin = true;
    }
    sessionStorage.clear();
    sessionStorage.setItem('currentUser', JSON.stringify(userData));

  }

  logout() {
    console.log('"Inside auth service logout()"');
    this.loggedIn = false;
    sessionStorage.clear();
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

  setUserData(userData) {
    this.userData = userData;
  }

  getUserData() {
    return this.userData;
  }

  setLanguageCode(code) {
    this.code = code;
  }

  getLanguageCode() {
    return this.code;
  }
}
