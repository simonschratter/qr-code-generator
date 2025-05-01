import {Component} from '@angular/core';
import {ReactiveFormsModule, Validators, FormGroup, FormControl} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {WifiQrService} from './wifi-generator.service';

@Component({
  standalone: true,
  selector: 'app-wifi-qr-generator',
  templateUrl: './wifi-generator.component.html',
  styleUrls: ['./wifi-generator.component.css'],
  imports: [CommonModule, ReactiveFormsModule],
})

export class WifiQrGeneratorComponent {
  qrImage: string | null = null;
  form: FormGroup = new FormGroup({
    ssid: new FormControl('', Validators.required),
    password: new FormControl(),
    encryption: new FormControl('WPA', Validators.required),
    hidden: new FormControl(false),
    imageType: new FormControl('JPG', Validators.required),
  });

  constructor(private qrService: WifiQrService) {
  }


  public generateQrCode(): void {
    if (this.form.valid) {
      this.qrService.generateWifiQr(this.form.value).subscribe((blob: Blob) => {
        const reader = new FileReader();
        reader.onload = () => {
          this.qrImage = reader.result as string;
          console.log(this.qrImage);
        };
        reader.readAsDataURL(blob);
      });
    }
  }
}
