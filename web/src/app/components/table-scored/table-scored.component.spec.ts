import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableScoredComponent } from './table-scored.component';

describe('TableScoredComponent', () => {
  let component: TableScoredComponent;
  let fixture: ComponentFixture<TableScoredComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableScoredComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableScoredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
