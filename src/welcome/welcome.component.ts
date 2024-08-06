import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TitlePipe } from '../title.pipe';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [CommonModule,TitlePipe],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent implements OnInit
{
  username:any="";
  
  imgurl : string="assets/images/one.jpg";

  birthdate:Date=new Date(2000,1,26);// yyyy/MM/day

  ngOnInit(): void 
  {
    
    this.username=sessionStorage.getItem('username');
  }

  show:boolean=false;

  persons:any[]=
[

{name:'sachin',country:'india'},

{name:'mac',country:'america'},

{name:'zen',country:'france'},

{name:'mahesh',country:'india'},

]

getColor(coutryname:string)
{
	switch(coutryname)
	{

   	 case 'india':
		return 'green';

	case 'america':
		return 'red';

	case 'france':
		return 'blue';
	}

	return "grey";	
}

}
