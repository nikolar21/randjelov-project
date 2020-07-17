import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MainService} from '../main.service';
import {Constants} from '../shared/constants';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  registrationMessage: string;
  registerForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    positionName: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  constructor(private mainService: MainService) { }

  ngOnInit() {
  }

  registerOperator() {
    this.mainService.registerOperator(this.registerForm.value).subscribe(data => {
      if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_SUCCESS) {
        console.log(data);
        this.registrationMessage = 'Successfully registered operator';
      } else {
        this.registrationMessage = 'Operator registration failed';
      }
    });
  }

}
