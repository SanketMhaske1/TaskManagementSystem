import { Component } from '@angular/core';
import { LoginClass } from '../../TaskClass/login-class';
import { ApiServiceService } from '../../api-service.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signup-component',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './signup-component.component.html',
  styleUrl: './signup-component.component.css'
})
export class SignupComponentComponent {

  userobj:LoginClass = new LoginClass();

  constructor(private signupservice:ApiServiceService,private router:Router){}

  save(userdata:LoginClass)
  {
    this.signupservice.newUser(this.userobj).subscribe((data:any)=>{
        this.userobj=data;
        console.log(data);
        this.router.navigate(['/navbar',]);

    }),
    (error:any)=>console.log(error);
  }

  navigateToLogin()
  {
    this.router.navigate(['/login'])
  }

}





