import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Route, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { LoginClass } from '../../TaskClass/login-class';
import { ApiServiceService } from '../../api-service.service';
import { error } from 'console';

@Component({
  selector: 'app-login-component',
  standalone: true,
  imports: [FormsModule,RouterOutlet],
  templateUrl: './login-component.component.html',
  styleUrl: './login-component.component.css'
})
export class LoginComponentComponent {

  userobj:LoginClass=new LoginClass();
  constructor(private loginservice:ApiServiceService,private router:Router){}

  onSubmit(user:LoginClass)
  {
    console.log(this.userobj);
    this.loginservice.userLogin(this.userobj).subscribe((data:any)=>{
      console.log(this.userobj);
      this.router.navigate(['/navbar']);
    }),
    (error:any)=>console.log(error);
  }

  navigateToSignup()
  {
    this.router.navigate(['/signup'])
  }

}
