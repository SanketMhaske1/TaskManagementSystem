import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon'
import { Router } from '@angular/router';
import { ApiServiceService } from '../../api-service.service';
import { TaskData } from '../../TaskClass/task-data';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { error } from 'console';

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [MatIconModule,FormsModule,CommonModule],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

  taskList:TaskData[]=[];
  constructor(private router:Router,private taskservice:ApiServiceService){}

  navigateToLogin()
  {
    this.router.navigate(['']);
  }

  

  navigateToHome()
  {
    this.router.navigate(['/navbar'])
  }

  ngOnInit()
  {
    this.taskservice.getAllTaskOfUser().subscribe((data:any)=>{
      this.taskList=data;
      console.log(data.userId);
      this.router.navigate(['/navbar'])
    }),
    (error:any)=>console.log(error);
  }

  delete(taskobj:TaskData)
  {
    this.taskservice.deleteSelectedTask(taskobj).subscribe((data:any)=>{
      this.taskList=this.taskList.filter(task=>task.taskId!==taskobj.taskId);
    }),
    (error:any)=>console.log(error);
  }

  confirmDelete(task:any):void{

    const confirmation=confirm("Are You Sure You Want To Delete This Task?");

    if(confirmation)
    {
      this.delete(task);
    }

  }


  navigateToCreateTask()
  {
    this.router.navigate(['/create'])
  }

  edit(taskobj:TaskData)
  {
    this.router.navigate(['/edit/'+taskobj.taskId]);
  }

}
