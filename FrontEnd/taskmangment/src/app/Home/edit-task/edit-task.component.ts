import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TaskData } from '../../TaskClass/task-data';
import { ApiServiceService } from '../../api-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-edit-task',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './edit-task.component.html',
  styleUrl: './edit-task.component.css'
})
export class EditTaskComponent {
  taskNew: TaskData = new TaskData();
  taskId!:string;
  constructor(private taskService: ApiServiceService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam !== null) {

        this.taskId = idParam;

        this.taskService.getTaskById(this.taskId).subscribe((data:any)=>{
          this.taskNew=data;
        }),
        (error:any)=>console.log(error)}

    } 

    save(taskobj:TaskData){
      this.taskService.updateSelectedTask(taskobj).subscribe((data:any)=>{
        this.router.navigate(['/navbar']);
      }),
      (error:any)=>console.log(error);

    }
    
  


}


