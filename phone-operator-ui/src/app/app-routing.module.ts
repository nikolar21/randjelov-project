import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterPageComponent} from './register-page/register-page.component';
import {OperatorPageComponent} from './operator-page/operator-page.component';
import {ClientPageComponent} from './client-page/client-page.component';
import {LoginPageComponent} from './login-page/login-page.component';

const routes: Routes = [
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent },
  { path: 'operator-page', component: OperatorPageComponent },
  { path: 'client-page', component: ClientPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
