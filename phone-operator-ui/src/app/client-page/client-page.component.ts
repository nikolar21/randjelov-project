import { Component, OnInit } from '@angular/core';
import {UserDetails} from '../shared/user-details';
import {Constants} from '../shared/constants';
import {Router} from '@angular/router';

@Component({
  selector: 'app-client-page',
  templateUrl: './client-page.component.html',
  styleUrls: ['./client-page.component.css']
})
export class ClientPageComponent implements OnInit {

  client: UserDetails;
  constructor(private router: Router) { }

  ngOnInit() {
    this.client = JSON.parse(localStorage.getItem(Constants.USER_DETAILS));
  }

  logoutUser() {
  localStorage.clear
  this.router.navigate(['/login']);

  }

}
