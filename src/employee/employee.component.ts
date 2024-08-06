import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent 
{
  // Employee employee=new Employee(101,'sachin',100000); // JAVA

    employee:Employee=new Employee(101,'sachin',100000);

    age:number=30;

    update()
    {
      this.employee.name='raghav';
      console.log('age value is ' + this.age);    
    }

}// class ends

class Employee
{
  eid:number;
  name:string;
  salary:number;

  constructor(eid:number,name:string,salary:number)
  {
    this.eid=eid;
    this.name=name;
    this.salary=salary;
  }

}
