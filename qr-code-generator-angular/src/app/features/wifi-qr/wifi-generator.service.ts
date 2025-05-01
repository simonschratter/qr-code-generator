import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class WifiQrService {
  private apiUrl = 'http://localhost:8080/api/qrcode/wifi';

  constructor(private http: HttpClient) {}

  generateWifiQr(data: any) {
    return this.http.post(this.apiUrl, data, { responseType: 'blob' });
  }
}
