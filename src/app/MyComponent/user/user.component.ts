import { Component } from '@angular/core';
import { UserserviceService } from 'src/app/MyService/userservice.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  newdata:any;

  newCustomer: any;

  constructor(private userservice: UserserviceService){}


  ngOnInit(){
    this.userservice.findAllCity().subscribe(result => {
      this.newdata = result;
      console.log(result);
    });

    this.userservice.findAllCustomer().subscribe(result => {
      this.newCustomer = result;
      console.log(result);
    });
  }
}
