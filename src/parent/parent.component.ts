import { Component } from '@angular/core';
import { ChildComponent } from '../child/child.component';

@Component({
  selector: 'app-parent',
  standalone: true,
  imports: [ChildComponent],
  template: `<h1> Welcome to parent component</h1>   <app-child [message]='x'></app-child>`,
  styleUrl: './parent.component.css'
})
export class ParentComponent 
{
  x:string="Angular is easy";
}
