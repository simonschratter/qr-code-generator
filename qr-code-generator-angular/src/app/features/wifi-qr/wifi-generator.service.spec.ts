import { TestBed } from '@angular/core/testing';

import { WifiGeneratorService } from './wifi-generator.service';

describe('WifiGeneratorService', () => {
  let service: WifiGeneratorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WifiGeneratorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
