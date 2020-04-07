import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApplicationTransactionDTO} from "../model/ApplicationTransactionDTO";
import {Observable} from "rxjs";
import {Application} from "../model/Application";

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private readonly transUrl: string;

  constructor(private http: HttpClient) {
    this.transUrl = "http://localhost:8080/api/v1/leave/action";
  }

  public findAll(): Observable<ApplicationTransactionDTO[]> {
    return this.http.get<ApplicationTransactionDTO[]>(`${this.transUrl}/transaction`);
  }

  public findById(id: number): Observable<Application> {
    return this.http.get<Application>(`${this.transUrl}/transaction/${id}`)
  }

  public approve(application: ApplicationTransactionDTO){
    console.log(application);
    return this.http.post<ApplicationTransactionDTO>(`${this.transUrl}/approve`,application);
  }

  public confirm(application: ApplicationTransactionDTO){
    return this.http.post<ApplicationTransactionDTO>(`${this.transUrl}/confirm`,application);
  }

  public cancel(application: ApplicationTransactionDTO){
    return this.http.post<ApplicationTransactionDTO>(`${this.transUrl}/cancel`,application);
  }

  public reject(application: ApplicationTransactionDTO){
    this.http.post<ApplicationTransactionDTO>(`${this.transUrl}/reject`,application);
  }
}
