import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer, CustomerService } from 'src/app/MyService/customer.service';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent {
  customers: Customer[] = [];
  // customer: Customer;
  signupForm: FormGroup;

  // customer: Customer[];

  constructor(private customerService: CustomerService,private router: Router, private formBuilder: FormBuilder){
    // this.customer = Customer;
    // console.log(this.customer);
    this.signupForm = this.formBuilder.group({
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      gender: ['', Validators.required],
      city: ['', Validators.required],
      dob: ['', Validators.required],
      email: ['',[Validators.required, Validators.email]],
      contact_no: ['', [Validators.required, Validators.minLength(10)]],
      username: ['',Validators.required],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });
    
  }
  onSubmit(){
    if(this.signupForm.valid){
      const customer = this.signupForm.value as Customer
      this.customerService.insertData(customer).subscribe(
        (result) => {
          console.log(result);
          alert('Sign up successfull')
          this.gotoLogin();
        },
        (error) => {
          console.error('error occured:', error);
        }
      );
    } else {
      alert('enter the proper inputs')
    }
  }
  

  gotoLogin(){
    this.router.navigate(['/login'])
  }

}
