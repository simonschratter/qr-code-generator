import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {WifiQrGeneratorComponent} from './wifi-generator.component';



@NgModule({
  declarations: [],
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule, WifiQrGeneratorComponent],
  exports: [WifiQrGeneratorComponent]
})
export class WifiQrModule { }
