package com.schratter.qrcodegeneratorbff.controller;

import com.schratter.qrcodegeneratorbff.model.WifiRequest;
import com.schratter.qrcodegeneratorbff.service.QrCodeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qrcode")
@CrossOrigin(origins = "http://localhost:4200")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping("/wifi")
    public ResponseEntity<byte[]> generateWifiQr(@RequestBody WifiRequest wifi) throws Exception {
        byte[] image = qrCodeService.generateWifiQrCode(wifi);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }
}