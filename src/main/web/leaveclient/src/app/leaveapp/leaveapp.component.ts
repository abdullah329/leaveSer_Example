import {Component} from '@angular/core';
import {LeaveService} from '../service/leave.service'
import {ApplicationDTO} from '../model/ApplicationDTO';
import {DatePipe} from "@angular/common";
import {NgbDateParserFormatter, NgbDateStruct} from "@ng-bootstrap/ng-bootstrap";


@Component({
  selector: 'app-leaveapp',
  templateUrl: './leaveapp.component.html',
  styleUrls: ['./leaveapp.component.scss']
})
export class LeaveappComponent {
  loading: boolean;

  application: ApplicationDTO;
  stDate: NgbDateStruct;
  constructor(
    private parserFormatter: NgbDateParserFormatter,
    // public toastr: ToastrService,
    // private route: ActivatedRoute,
    private leaveService: LeaveService) {
    this.application = new ApplicationDTO();
  }


  onSubmit() {
    this.loading = true;
    this.application.startDateAg = this.parserFormatter.format(this.stDate);
    console.log(this.application.startDateAg);
    this.leaveService.addApplication(this.application).subscribe(result => this.leaveService.findAll());
    this.loading = false;
    // this.toastr.success('تم إرسال طلبك', '--<>--', {progressBar: true});
    console.log(this.application)
  }


}
