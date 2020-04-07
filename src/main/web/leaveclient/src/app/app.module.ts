import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
// import { NgForm } from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {LeaveappComponent} from './leaveapp/leaveapp.component';
import {LeavetransComponent} from './leavetrans/leavetrans.component';
import {LeavebalanceComponent} from './leavebalance/leavebalance.component';
import {LeaveService} from './service/leave.service';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule, DatePipe} from "@angular/common";
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {LaddaModule} from "angular2-ladda";
import {NgxEchartsModule} from "ngx-echarts";
import {LeaveEmpAppsComponent} from './leave-emp-apps/leave-emp-apps.component';


@NgModule({
  declarations: [
    AppComponent,
    LeaveappComponent,
    LeavetransComponent,
    LeavebalanceComponent,
    LeaveEmpAppsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    CommonModule,
    NgbModule,
    NgxEchartsModule,
    FormsModule,
    ReactiveFormsModule,
    LaddaModule.forRoot({style: 'expand-left'}),
    NgxDatatableModule
  ],
  providers: [LeaveService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule {
}
