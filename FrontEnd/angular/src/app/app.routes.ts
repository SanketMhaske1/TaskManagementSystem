import { Routes } from '@angular/router';
import { SignupComponentComponent } from './LoginsignupComponent/signup-component/signup-component.component';
import { NavBarComponent } from './Home/nav-bar/nav-bar.component';
import { LoginComponentComponent } from './LoginsignupComponent/login-component/login-component.component';
import { CreateTaskComponent } from './Home/create-task/create-task.component';
import { EditTaskComponent } from './Home/edit-task/edit-task.component';

export const routes: Routes = [

    {path:"signup",component:SignupComponentComponent},
    {path:"navbar",component:NavBarComponent},
    {path:"",redirectTo:"login",pathMatch:'full'},
    {path:"login",component:LoginComponentComponent},
    {path:"create",component:CreateTaskComponent},
    {path:"edit/:id",component:EditTaskComponent}

];
