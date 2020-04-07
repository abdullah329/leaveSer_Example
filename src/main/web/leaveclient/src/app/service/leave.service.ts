import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Balance} from '../model/Balance';
import {ApplicationDTO} from '../model/ApplicationDTO';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  private readonly leaveUrl: string;
  private readonly addrequestUrl: string;

  constructor(private http: HttpClient) {
    this.leaveUrl = 'http://localhost:8080/api/v1/leave/application';
    this.addrequestUrl = 'http://localhost:8080/api/v1/leave/application/addLeave'

  }

  public findBalance(type: number): Observable<Balance[]> {
    return this.http.get<Balance[]>(`${this.leaveUrl}/balance?type=${type}`);
  }

  public addApplication(application: ApplicationDTO) {
    console.log(application);
    return this.http.post<ApplicationDTO>(this.addrequestUrl, application);
  }

  public findAll(): Observable<ApplicationDTO[]> {
    return this.http.get<ApplicationDTO[]>(`${this.leaveUrl}/leaves`);
  }
}
