import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isLoggedIn = false;
  private user: any;

  login(userData: any) {
    this.isLoggedIn = true;
    this.user = userData;
  }

  logout() {
    this.isLoggedIn = false;
    this.user = null;
  }

  isLoggedInUser(): boolean {
    return this.isLoggedIn;
  }

  getUserDetails():any {
    return this.user;
  }

}

