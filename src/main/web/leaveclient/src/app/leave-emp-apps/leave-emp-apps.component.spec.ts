import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveEmpAppsComponent } from './leave-emp-apps.component';

describe('LeavEmpAppsComponent', () => {
  let component: LeaveEmpAppsComponent;
  let fixture: ComponentFixture<LeaveEmpAppsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveEmpAppsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveEmpAppsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
