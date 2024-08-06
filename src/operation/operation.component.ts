import { Component } from '@angular/core';
import { MathsService } from '../maths.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-operation',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './operation.component.html',
  styleUrl: './operation.component.css'
})
export class OperationComponent 
{
  
  no:number=0;
  answer:number=0;

  //@Autowired
  //MathsService op;

  constructor(private op:MathsService)
  {
    
  }
  
  calculateCube()
  {
    this.answer=this.op.calculateCube(this.no);
  }
  
}
