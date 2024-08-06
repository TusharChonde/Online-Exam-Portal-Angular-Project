import { Injectable } from '@angular/core';
import { User } from './user.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpclient:HttpClient) { }

  validateUser(user:User):Observable<boolean>
  {
    return this.httpclient.post<boolean>("http://localhost:7777/validate",user);
  }
}
