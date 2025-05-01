import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class QrService {
  private wifiApiUrl = 'http://localhost:8080/api/qrcode/wifi';
  private urlApiUrl = 'http://localhost:8080/api/qrcode/url';

  constructor(private http: HttpClient) {
  }

  generateWifiQr(data: any) {
    return this.http.post(this.wifiApiUrl, data, {responseType: 'blob'});
  }

  generateUrlQr(data: any) {
    return this.http.post(this.urlApiUrl, data, {responseType: 'blob'});
  }
}
