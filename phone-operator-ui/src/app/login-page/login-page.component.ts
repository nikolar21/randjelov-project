import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MainService} from '../main.service';
import {Router} from '@angular/router';
import {Constants} from '../shared/constants';
import {UserDetails} from '../shared/user-details';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  errorMessage: string;
  loginForm = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });
  constructor(private mainService: MainService,
              private router: Router) { }

  ngOnInit() {
  }

  loginUser() {
    this.mainService.loginUser(this.loginForm.value).subscribe(data => {
      console.log(data[Constants.STATUS_RESPONSE_KEY]);
      if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_SUCCESS) {
        const userDetails: UserDetails = data[Constants.USER_DETAILS_RESPONSE_KEY];
        localStorage.setItem(Constants.USER_DETAILS, JSON.stringify(userDetails));
        if (userDetails.accountType === Constants.OPERATOR_ACCOUNT_TYPE) {
          this.router.navigate(['/operator-page']);
        } else if (userDetails.accountType === Constants.CLIENT_ACCOUNT_TYPE) {
          this.router.navigate(['/client-page']);
        }
      } else {
        this.errorMessage = 'Wrong credentials';
      }
    });
  }

}
