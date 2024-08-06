
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';


@Component({
  selector: 'app-student',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student.component.html',
  styleUrl: './student.component.css'
})
export class StudentComponent 
{
  // arrayname : type =[ values ];

  // values can be numbers , strings , javascript object , Employee object etc .

  students:any[]=[{rno:1,name:'sandip'},{rno:2,name:'samrudhi'},{rno:3,name:'sakshi'}];

}
