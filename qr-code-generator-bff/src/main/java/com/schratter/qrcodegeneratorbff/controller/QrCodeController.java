package com.schratter.qrcodegeneratorbff.controller;

import com.google.zxing.WriterException;
import com.schratter.qrcodegeneratorbff.model.dto.RequestImageType;
import com.schratter.qrcodegeneratorbff.model.dto.url.UrlRequestDTO;
import com.schratter.qrcodegeneratorbff.model.dto.wifi.WifiRequestDTO;
import com.schratter.qrcodegeneratorbff.service.QrCodeService;
import jakarta.validation.Valid;
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
        RequestImageType imageType = wifi.getValidatedImageType();
        byte[] image = qrCodeService.generateWifiQrCode(wifi);

        return ResponseEntity.ok()
                .contentType(imageType.getMimeType())
                .body(image);
    }

    @PostMapping("/url")
    public ResponseEntity<byte[]> generateUrlQr(@Valid @RequestBody UrlRequestDTO url) throws IOException, WriterException {
        RequestImageType imageType = url.getValidatedImageType();
        byte[] image = qrCodeService.generateUrlQrCode(url);

        return ResponseEntity.ok()
                .contentType(imageType.getMimeType())
                .body(image);
    }
}