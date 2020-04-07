import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LeaveappComponent } from './leaveapp/leaveapp.component';
import { LeavebalanceComponent } from './leavebalance/leavebalance.component';


const routes: Routes = [
  { path: 'leaveapp', component: LeaveappComponent },
  { path: 'balance', component: LeavebalanceComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
