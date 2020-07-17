import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Constants} from './shared/constants';
import {catchError} from 'rxjs/operators';
import {UserDetails} from './shared/user-details';
import {ResourcesInfo} from './shared/resources-info';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private http: HttpClient) { }

  registerOperator(operatorDetails: UserDetails) {
    return this.http.post(Constants.SERVER_LOCATION + '/register-operator', operatorDetails);
  }

  registerClient(clientDetails: any) {
    return this.http.post(Constants.SERVER_LOCATION + '/register-client', clientDetails);
  }

  loginUser(userDetails: UserDetails) {
    console.log(userDetails);
    return this.http.post(Constants.SERVER_LOCATION + '/authenticate', userDetails);
  }

  getAllClients() {
    return this.http.get(Constants.SERVER_LOCATION + '/get-clients');
  }

  addResourcesForGivenClient(resourcesInfo: ResourcesInfo) {
    return this.http.post(Constants.SERVER_LOCATION + '/add-resources', resourcesInfo);
  }
}
