import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { LoginService } from '../login.service';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  signup = new FormGroup({
    name: new FormControl(),
    email: new FormControl(),
    password: new FormControl(),
    language: new FormControl(),
  });

  login = new FormGroup({
    email: new FormControl(),
    password: new FormControl(),
  });

  signUpStatus: any;
  signedUp: boolean;
  emailExists: boolean;
  error: any;
  json: any;
  languageList: any;
  signUpUserJson: any;
  constructor(private loginService: LoginService, private signUpService: SignupService) { }

  ngOnInit() {
  }

  getLanguages() {
    this.signUpService.getallLanguages().subscribe(data => {
      this.languageList = data;
      console.log(this.languageList);
    });

  }

  Signup() {
    this.signUpStatus = null;
    this.signedUp = null;
    this.emailExists = null;
    this.signUpUserJson = JSON.stringify({
      name: this.signup.controls['name'].value,
      email: this.signup.controls['email'].value,
      password: this.signup.controls['password'].value,
      status: 'active',
      language: {
        id: this.signup.controls['language'].value,
      },
      role: {
        id: 1,
      }
    });
    console.log(this.signUpUserJson);
    this.signUpService.addUser(this.signUpUserJson).subscribe(data => {
      this.signUpStatus = data;
      this.signedUp = this.signUpStatus.signedUp;
      this.emailExists = this.signUpStatus.emailExists;
    },
      error => {
        this.error = error;
      });
    localStorage.clear();
  }
}
