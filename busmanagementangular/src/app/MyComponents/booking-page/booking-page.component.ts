import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {  FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Booking, UserserviceService } from 'src/app/MyService/userservice.service';
import { AuthService } from 'src/app/MyService/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-page',
  templateUrl: './booking-page.component.html',
  styleUrls: ['./booking-page.component.css']
})
export class BookingPageComponent implements OnInit {
  
  bookingForm: FormGroup;
  newCity: any;
  customer: any;
  postedbooking: any;
  postedBook: any = [];
  showTable: boolean = false;
  showTable1: boolean = false;
  selectedPeople: any = [];
  booking1: any[] = [];
  bookings: any[] = [];
  historyData: any;
  people: string= '';

  login: boolean = false;

  get persons(): FormArray{
    return <FormArray> this.bookingForm.get[persons];
  }

  // peopleOptions = ['0','1', '2', '3', '4', '5'];

  constructor(private userService: UserserviceService, private formBuilder: FormBuilder,private authService:AuthService , private http: HttpClient, private router: Router){
    
    this.bookingForm = this.formBuilder.group({
      firstname: ['', Validators.required],
      lastname: ['',Validators.required],
      dob: ['',[Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      gender: ['', Validators.required],
      contact_no: ['', [Validators.required, Validators.minLength(10)]],
      startpoint: ['',Validators.required],
      endpoint: ['', Validators.required],
      people: '0',
      bookingid: 0
    });
  }

  ngOnInit(): void {
    this.userService.findAllCity().subscribe(result => {
      this.newCity = result;
    });

    //this.customer = this.authService.getUserDetails();
    this.customer = 1;
    this.login = true;
    // console.log(this.bookingForm);
    
  }
  booking(){
    console.log(this.persons);
    this.booking1= [];
    // if(this.bookingForm.valid){
    
        const bookings = {
        ...this.bookingForm.value,
        customerid: this.customer.customerid
      } as Booking;
      // console.log(bookings);
 
this.booking1.push(bookings)
console.log(this.booking1)
    this.userService.insertData(this.booking1).subscribe(
      (result)=> {
        this.postedbooking = result
        alert('booking successful');
        console.log(this.postedbooking);
        
      },
      (error) => {
        alert("something went wrong")
        console.error('error occured',error);
        
      }
    )
        
    // } else {
    //   alert('enter the proper inputs')
    //   console.log("error");
      
    // }
  }
  display(){
    this.postedBook= [];
    this.showTable = true;
    this.showTable1 = false;
    console.log(this.postedbooking);
    for(let book of this.postedbooking){
      console.log(book.bookingid);
      
      // for(let i=0; i< this.postedbooking.length;i++){
      this.http.get<any>('http://localhost:8080/booking/getbook/'+book.bookingid).subscribe(
        (result) => {
          this.postedBook.push(result);
          // console.log("bookings" + this.postedbooking);
          
        }
      )
    // }
    }
  }

  onPeopleChange() {
    this.selectedPeople.length = this.bookingForm.get('people')?.value || '0';
    // this.booking1.length = this.selectedPeople.length
  }

  logout() {
    this.authService.logout()
    this.router.navigate(['/login'])
  }

  history() {
    this.showTable = false;
    this.showTable1 = true;
    this.http.get<any>('http://localhost:8080/booking/customer?customerid='+this.customer.customerid).subscribe(
      (result) => {

        this.historyData = result
        
      }
      )
  }
}

