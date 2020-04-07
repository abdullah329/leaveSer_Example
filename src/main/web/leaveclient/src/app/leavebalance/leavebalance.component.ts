import { Component, OnInit } from '@angular/core';
import { LeaveService } from '../service/leave.service'
import { Balance } from '../model/Balance';

@Component({
  selector: 'app-leavebalance',
  templateUrl: './leavebalance.component.html',
  styleUrls: ['./leavebalance.component.scss']
})
export class LeavebalanceComponent implements OnInit {

  balances: Balance[];

  constructor(private leaveService: LeaveService) { }

  ngOnInit(): void {
    this.leaveService.findBalance(1).subscribe((data: Balance[]) => {
      console.log(data);
      return this.balances = data;
    });
  }

}
