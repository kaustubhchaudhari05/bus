import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
bookings: any[] = [];
  // private usersUrl: string;

  constructor(private http: HttpClient) { 
    // this.usersUrl = 'http://localhost:8080/booking/getcity'
    this.bookings.push(Booking)
  }

  findAllCity(){
    return this.http.get('http://localhost:8080/city/getcity');
  }

  findAllCustomer(){
    return this.http.get('http://localhost:8080/customer/getcustomer');
  }

  insertData(booking: Booking[]): Observable<Booking[]> {
    console.log(booking);
    
    return this.http.post<Booking[]>('http://localhost:8080/booking/savebooking',booking);
  }

}

export class Booking{
  constructor(
    public firstname: string,
    public lastname: string,
    public dob: Date,
    public email: string,
    public gender: string,
    public contact_no: number,
    public startpoint: string,
    public endpoint: string,
    public customerid: number
  ) {}
}
