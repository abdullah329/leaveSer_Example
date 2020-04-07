import { Component, OnInit } from '@angular/core';
import {ApplicationTransactionDTO} from "../model/ApplicationTransactionDTO";
import {Application} from "../model/Application";
import {TransactionService} from "../service/transaction.service";

@Component({
  selector: 'app-leavetrans',
  templateUrl: './leavetrans.component.html',
  styleUrls: ['./leavetrans.component.css']
})
export class LeavetransComponent implements OnInit {

  transactions: ApplicationTransactionDTO[];
  application: Application[];
  constructor(private transService: TransactionService) { }

  ngOnInit(): void {
    this.transService.findAll().subscribe((data: ApplicationTransactionDTO[]) => {
      this.transactions = data;
      console.log(this.transactions);
    })
  }

  approve(event: ApplicationTransactionDTO){
    console.log(event);
    this.transService.approve(event).subscribe(result => {this.transService.findAll()});
  }

  confirm(event: ApplicationTransactionDTO){
    this.transService.confirm(event).subscribe(result => {this.transService.findAll()});
  }

}
