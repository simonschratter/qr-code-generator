import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WifiGeneratorComponent } from './wifi-generator.component';

describe('WifiGeneratorComponent', () => {
  let component: WifiGeneratorComponent;
  let fixture: ComponentFixture<WifiGeneratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WifiGeneratorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WifiGeneratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
