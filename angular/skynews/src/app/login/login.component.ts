import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../login.service';
import { SignupService } from '../signup.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  signup = new FormGroup({
    name: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(80)])),
    email: new FormControl('', Validators.compose([Validators.required, Validators.email, Validators.maxLength(80)])),
    password: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(80)])),
    language: new FormControl('', Validators.compose([Validators.required, Validators.maxLength(80)])),
  });

  sign_up_form_validators = {
    name: [
      { type: 'required', message: 'Email Id is Required' },
      { type: 'maxlength', message: 'Maximum Lenght allowed is 80 characters' },
    ],
    email: [
      { type: 'required', message: 'Email Id is Required' },
      { type: 'email', message: 'Please enter a valid email Id' },
      { type: 'maxlength', message: 'Maximum Lenght allowed is 80 characters' },
    ],
    password: [
      { type: 'required', message: 'Password cannot be blank' },
      { type: 'minlength', message: 'Password must be between 6 to 18 characters' },
      { type: 'maxlength', message: 'Password must be between 6 to 18 characters' },
    ],
    language: [
      { type: 'required', message: 'Please Select a langauge' }
    ]
  };

  login = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  isBlocked: boolean;
  incorrectLogin: any;
  signUpStatus: any;
  signedUp: boolean;
  emailExists: boolean;
  error: any;
  errorLogin: any;
  json: any;
  languageList: any;
  signUpUserJson: any;
  // tslint:disable-next-line:max-line-length
  constructor(private loginService: LoginService, private signUpService: SignupService, private router: Router, private service: AuthService) { }

  ngOnInit() {

  }

  getLanguages() {
    this.signUpService.getallLanguages().subscribe(data => {
      this.languageList = data;
      console.log(this.languageList);
    });

  }

  Login() {
    this.loginService.loginUser(this.login.value).subscribe(data => {
      console.log(data);
      if (data.authenticated) {
        this.service.login(data);
        //  this.service.setUserData(data.actualUser);
        this.service.setLanguageCode(data.actualUser.language.code);
        console.log(data.actualUser.language.code);
        if (data.actualUser.status !== 'blocked') {
          this.router.navigate(['/article']);
        }
        if (data.actualUser.status === 'blocked') {
          this.isBlocked = true;
          this.login.reset();
        }
      } else {
        this.incorrectLogin = true;
      }
    },
      error => {
        this.errorLogin = error;
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
      if (this.signedUp) {
        this.signup.reset();
      }
      this.emailExists = this.signUpStatus.emailExists;
    },
      error => {
        this.error = error;
      });
    localStorage.clear();
  }
}
