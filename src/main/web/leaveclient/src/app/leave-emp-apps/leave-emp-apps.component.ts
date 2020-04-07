import { Component, OnInit } from '@angular/core';
import {ApplicationDTO} from "../model/ApplicationDTO";
import {LeaveService} from "../service/leave.service";

@Component({
  selector: 'app-leave-emp-apps',
  templateUrl: './leave-emp-apps.component.html',
  styleUrls: ['./leave-emp-apps.component.css']
})
export class LeaveEmpAppsComponent implements OnInit {

  applications: ApplicationDTO[];

  constructor(private leaveService: LeaveService) { }

  ngOnInit() {
    this.leaveService.findAll().subscribe( (data: ApplicationDTO[]) => {
      return this.applications = data;
    })
  }

}
