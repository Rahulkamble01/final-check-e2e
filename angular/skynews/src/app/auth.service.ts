import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  userData: any;
  authenticationData: any;
  loggedIn = false;
  isAdmin = false;
  code: any;

  constructor(private router: Router) { }


  login(authenticationData) {
    console.log('"Inside auth service login()"');
    sessionStorage.clear();
    this.loggedIn = true;
    this.setUserData(authenticationData.actualUser);

    if (this.userData.role.description === 'admin') {
      this.isAdmin = true;
    }

    sessionStorage.setItem('currentUser', JSON.stringify(authenticationData));

  }

  logout() {
    console.log('"Inside auth service logout()"');
    this.loggedIn = false;
    sessionStorage.clear();
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

  setAuthenticationData(authenticationData) {
    this.authenticationData = authenticationData;
  }

  getauthenticationData() {
    return this.authenticationData;
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

  setToke() {

  }

  getLanguageCode() {
    return this.code;
  }
}
