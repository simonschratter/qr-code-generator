package com.schratter.qrcodegeneratorbff.controller;

import com.google.zxing.WriterException;
import com.schratter.qrcodegeneratorbff.model.dto.wifi.WifiRequestDTO;
import com.schratter.qrcodegeneratorbff.service.QrCodeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/qrcode")
@CrossOrigin(origins = "http://localhost:4200")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping("/wifi")
    public ResponseEntity<byte[]> generateWifiQr(@Valid @RequestBody WifiRequestDTO wifi) throws IOException, WriterException {
        byte[] image = qrCodeService.generateWifiQrCode(wifi);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}