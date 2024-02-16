import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginClass } from './TaskClass/login-class';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { TaskData } from './TaskClass/task-data';
import { catchError, tap } from 'rxjs/operators';
import { response } from 'express';
import { error } from 'console';


@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  private baseUrl="http://localhost:8081/user";
  userId!:string

  constructor(private httpClient:HttpClient) { }


  userLogin(user: LoginClass): Observable<Object> {
    console.log(`${user.userName}  ${user.userPassword}`)
    
    return this.httpClient.get(`${this.baseUrl}/${user.userName}/${user.userPassword}`).pipe(
      tap((response: any) => {
        console.log(response)
        if(response!==0)
        {
          this.userId=response;
          console.log(`${this.userId} This IsUserId`);
        }
        else{
          throw{error:"User is Not Persent"}
        }

      })
      
    );
  }
  

  newUser(user:LoginClass):Observable<Object>
  {
    return this.httpClient.post(`${this.baseUrl}`+"/newUser",user)
    .pipe(
      tap((response: any) => {
        this.userId=response.userId;
      })
    );


  }

  getAllTaskOfUser():Observable<Object>
  {
    return this.httpClient.get(`${this.baseUrl}/task/${this.userId}`);
  }

  getTaskById(id:string):Observable<object>{
    return this.httpClient.get(`${this.baseUrl}/taskByID/${this.userId}/${id}`)
  }

  createNewTask(taskobj:TaskData):Observable<Object>
  {
    console.log(this.userId);
    return this.httpClient.post(`${this.baseUrl}/newTaskAdd/${this.userId}`,taskobj);
  }

  updateSelectedTask(taskObj:TaskData):Observable<Object>
  {
    console.log(`user+${this.userId}+taskid+${taskObj.taskId}`)
    const url=`${this.baseUrl}/updateTask/${this.userId}/${taskObj.taskId}`;
    return this.httpClient.put(`${url}`,taskObj);
  }

  deleteSelectedTask(taskObj:TaskData):Observable<Object>
  {
   return this.httpClient.delete(`${this.baseUrl}/deleteTask/${this.userId}/${taskObj.taskId}`)
  }

  
}










