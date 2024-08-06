import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
// import { ChildComponent } from './child/child.component';
// import { ParentComponent } from './parent/parent.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,FormsModule,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent 
{

    no1:number=0;
    no2:number=0;
    answer:number=0;

    add():void
    {
          this.answer=this.no1+this.no2;
    }

    subtract()
    {
          this.answer=this.no1-this.no2;
    }

}
