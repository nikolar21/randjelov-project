import { Component, OnInit } from '@angular/core';
import {MainService} from '../main.service';
import {UserDetails} from '../shared/user-details';
import {Constants} from '../shared/constants';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ResourcesInfo} from '../shared/resources-info';

@Component({
  selector: 'app-operator-page',
  templateUrl: './operator-page.component.html',
  styleUrls: ['./operator-page.component.css']
})
export class OperatorPageComponent implements OnInit {

  clientArray: Array<UserDetails>;
  errorMessage: string;
  registrationMessage: string;
  registerClientForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
  constructor(private mainService: MainService) { }

  ngOnInit() {
    this.mainService.getAllClients().subscribe(data => {
      if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_SUCCESS) {
        this.clientArray = data['clientArray'];
      } else if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_FAIL) {
        this.errorMessage = 'There was an error in getting the clients';
      }
    });
  }

  registerClient() {
    this.mainService.registerClient(this.registerClientForm.value).subscribe(data => {
      if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_SUCCESS) {
        this.registrationMessage = 'Successfully registered new client';
      } else if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_FAIL) {
        this.registrationMessage = 'There was and error in registering new client';
      }
    });
  }

  addResources(client: UserDetails) {
    const resourcesInfo: ResourcesInfo = {
      clientEmail: client.email,
      minutesToAdd: 5,
      megabytesToAdd: 100,
      messagesToAdd: 20
    };
    this.mainService.addResourcesForGivenClient(resourcesInfo).subscribe(data => {
      if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_SUCCESS) {
        this.registrationMessage = 'Successfully registered new client';
      } else if (data[Constants.STATUS_RESPONSE_KEY] === Constants.API_RESPONSE_FAIL) {
        this.registrationMessage = 'There was and error in registering new client';
      }
    });
  }

}
