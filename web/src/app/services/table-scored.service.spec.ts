import { TestBed } from '@angular/core/testing';

import { TableScoredService } from './table-scored.service';

describe('TableScoredService', () => {
  let service: TableScoredService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TableScoredService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
