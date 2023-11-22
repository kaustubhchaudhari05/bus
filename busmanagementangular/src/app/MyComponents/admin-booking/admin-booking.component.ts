import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/MyService/auth.service';

@Component({
  selector: 'app-admin-booking',
  templateUrl: './admin-booking.component.html',
  styleUrls: ['./admin-booking.component.css']
})
export class AdminBookingComponent implements OnInit{

  newData: any;
  selectedBookingData: any;
  admin: any;
  showTable: boolean = false;
  showSelectedBookingTable: boolean = false;

  constructor(private http: HttpClient, private authService: AuthService){}

  ngOnInit(): void {
      this.http.get('http://localhost:8080/booking/books').subscribe(
        (result) => {
          this.newData = result;
        }
      )

      this.http.get('http://localhost:8080/booking/maxfare').subscribe(
        (result) => {
          this.selectedBookingData = result
        }
      )

      this.admin = this.authService.getUserDetails();
  }

  Bookings() {
    this.showTable = true;
    this.showSelectedBookingTable = false;
  }

  selectedBookings(){
    this.showTable = false
    this.showSelectedBookingTable = true;
  }

}
