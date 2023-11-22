import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './MyComponent/user/user.component';
import { LoginPageComponent } from './MyComponents/login-page/login-page.component';
import { SignupPageComponent } from './MyComponents/signup-page/signup-page.component';
import { BookingPageComponent } from './MyComponents/booking-page/booking-page.component';
import { AdminBookingComponent } from './MyComponents/admin-booking/admin-booking.component';

const routes: Routes = [
  {path: 'user', component: UserComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'signup', component: SignupPageComponent},
  {path: 'booking', component:BookingPageComponent},
  {path: 'admin', component: AdminBookingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
