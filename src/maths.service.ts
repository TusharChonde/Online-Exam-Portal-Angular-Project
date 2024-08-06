import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MathsService 
{
  calculateCube(no:number)
  {
    return no*no*no;
  }

}
