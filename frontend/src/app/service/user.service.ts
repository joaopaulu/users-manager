import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly serverUrl: string = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}

  getUsers(
    name: string = '',
    page: number = 0,
    size: number = 10
  ): Observable<any> {
    return this.http.get<any>(
      `${this.serverUrl}?name=${name}&page=${page}&size=${size}`
    );
  }
}
