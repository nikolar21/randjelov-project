import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private http: HttpClient) { }

  registerOperator(operatorDetails: any) {
  }

  registerClient(clientDetails: any) {
  }

  loginUser(userDetails: any) {
  }
}
