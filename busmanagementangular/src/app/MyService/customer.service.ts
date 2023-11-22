import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  // getData(){
  //   return this.http.get('http://localhost:8080/customer/getcustomer');
  // }

// getCity(){
//   return this.http.get('http://localhost:8080/city/getcity');
// }
  getCustomer() {
    return this.http.get('http://localhost:8080/customer/getcustomer')
  }

  insertData(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>('http://localhost:8080/customer/savecustomer',customer);
  }
}

export class Customer {
  constructor(
    public firstname: string,
    public lastname: string,
    public gender: string,
    public city: string,
    public dob: Date,
    public email: string, 
    public contact_no: number,
    public username: string,
    public password: string,
  ) {}
}
