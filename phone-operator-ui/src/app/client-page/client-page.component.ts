import { Component, OnInit } from '@angular/core';
import {UserDetails} from '../shared/user-details';
import {Constants} from '../shared/constants';

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit {

  client: UserDetails;
  constructor() { }

  ngOnInit() {
    this.client = JSON.parse(localStorage.getItem(Constants.USER_DETAILS));
  }

}
