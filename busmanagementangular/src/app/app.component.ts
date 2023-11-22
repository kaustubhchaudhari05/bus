import { Component } from '@angular/core';
import { UserserviceService } from './MyService/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'busmanagementangular';
  newdata:any;
  showUser: boolean = false;
  showLogin: boolean = true;

  constructor(private userservice: UserserviceService, private router: Router){}

  openUser(){
    this.router.navigate(['/user'])
  }

  openLogin(){
    this.showLogin = false
    this.router.navigate(['/login'])
  }
 

  
}
