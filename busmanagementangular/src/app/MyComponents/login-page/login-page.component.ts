import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { forkJoin } from 'rxjs';
import { AuthService } from 'src/app/MyService/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  loginForm: FormGroup;
  // admin: any
  // customer: any

  constructor(private router: Router, private formBuilder: FormBuilder, private authService: AuthService, private http: HttpClient){
    this.loginForm = this.formBuilder.group({
      username: ['',Validators.required],
      password: ['',Validators.required]
    });
  }

  login() {
    if (this.loginForm.valid) {
      const adminRequest = this.http.get<any>('http://localhost:8080/admin/getadmin');
      const customerRequest = this.http.get<any>('http://localhost:8080/customer/getcustomer');
  
      forkJoin([adminRequest, customerRequest]).subscribe(
        ([adminResult, customerResult]) => {
          const admin = adminResult.find((a: any) => a.username === this.loginForm.value.username && a.password === this.loginForm.value.password);
          const customer = customerResult.find((c: any) => c.username === this.loginForm.value.username && c.password === this.loginForm.value.password);
  
          if (admin) {
            this.authService.login(admin);
            this.router.navigate(['/admin']);
          } else if (customer) {
            this.authService.login(customer);
            this.router.navigate(['/booking']);
          } else {
            alert('User not found');
          }
        },
        (error) => {
          alert('Something went wrong');
        }
      );
    } else {
      alert("enter the credentials")
    }
  }


  // login() {
  //   if(this.loginForm.valid){
      
  //     this.http.get<any>('http://localhost:8080/admin/getadmin').subscribe(
  //       (result) => {
  //         this.admin = result.find((a:any) => {
  //           console.log(result);
  //           return a.username === this.loginForm.value.username && a.password === this.loginForm.value.password
  //         });
  //       }
  //     )
  //     this.http.get<any>('http://localhost:8080/customer/getcustomer').subscribe(
  //       (result) => {
  //         this.customer = result.find((a: any) => {
  //           console.log(result);      
  //           return a.username === this.loginForm.value.username && a.password === this.loginForm.value.password
  //         });
  //       }
  //     )
      
      
  //     if(this.admin){
  //       this.authService.login(this.admin);
  //       this.router.navigate(['/admin']);
  //     } else if(this.customer) {
  //       this.authService.login(this.customer);
  //       this.router.navigate(['/booking'])
  //     } else {
  //       alert('user not found')
  //     }
  //   }
  // }

  openSignup(){
    this.router.navigate(['/signup'])
  }

}
