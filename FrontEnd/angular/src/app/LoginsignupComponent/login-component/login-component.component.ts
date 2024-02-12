import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Route, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { LoginClass } from '../../TaskClass/login-class';
import { ApiServiceService } from '../../api-service.service';

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

  onSubmit()
  {
    this.router.navigate(['/navbar'])
  }

  navigateToSignup()
  {
    this.router.navigate(['/signup'])
  }

}
