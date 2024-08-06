import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-addition',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './addition.component.html',
  styleUrl: './addition.component.css'
})
export class AdditionComponent 
{
  no1:number=10;
  no2:number=20;
  answer:number=0;

  add()
  {
      this.answer=this.no1+this.no2;
  }
  
}
