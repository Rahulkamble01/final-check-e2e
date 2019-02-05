import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  loggedIn: boolean;
  userData: any;
  constructor(public service: AuthService) { }

  ngOnInit() {
    this.userData = JSON.parse(sessionStorage.getItem('currentUser'));
  }

    logout() {
      this.service.logout();
      this.loggedIn = false;
    }

  }
