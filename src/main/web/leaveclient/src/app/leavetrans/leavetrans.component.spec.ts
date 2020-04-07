import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeavetransComponent } from './leavetrans.component';

describe('LeavetransComponent', () => {
  let component: LeavetransComponent;
  let fixture: ComponentFixture<LeavetransComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeavetransComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeavetransComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
