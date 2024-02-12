import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskData } from '../../TaskClass/task-data';
import { ApiServiceService } from '../../api-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-task',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './create-task.component.html',
  styleUrl: './create-task.component.css'
})
export class CreateTaskComponent {

  taskNew:TaskData=new TaskData();

  constructor(private newTaskService:ApiServiceService,private router:Router){}

  save(taskdata:TaskData)
  {

    this.newTaskService.createNewTask(this.taskNew).subscribe((data:any)=>{
      console.log(data);
      this.router.navigate(['/navbar']);
    }),
    (error:any)=>console.log(error);
  }


}


