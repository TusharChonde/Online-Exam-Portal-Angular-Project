import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'title',
  standalone: true
})
export class TitlePipe implements PipeTransform 
{

  transform(value: string,gender: string): string 
  {
    if(gender=='male')
      return "Mr." + value;
    else
      return "Mrs. " + value;
  }

}
