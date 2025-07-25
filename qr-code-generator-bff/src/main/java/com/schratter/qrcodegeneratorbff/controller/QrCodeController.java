package com.schratter.qrcodegeneratorbff.controller;

import com.google.zxing.WriterException;
import com.schratter.qrcodegeneratorbff.model.dto.RequestImageType;
import com.schratter.qrcodegeneratorbff.model.dto.url.UrlRequestDTO;
import com.schratter.qrcodegeneratorbff.model.dto.wifi.WifiRequestDTO;
import com.schratter.qrcodegeneratorservice.dao.entity.QrCodeEntity;
import com.schratter.qrcodegeneratorservice.service.QrCodeService;
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
    public ResponseEntity<byte[]> generateWifiQr(@Valid @RequestBody WifiRequestDTO wifiRequest) throws IOException, WriterException {
        RequestImageType imageType = wifiRequest.getValidatedImageType();
        String content = String.format("WIFI:T:%s;S:%s;P:%s;H:%s;;", wifiRequest.getEncryption(), wifiRequest.getSsid(), wifiRequest.getPassword(), wifiRequest.isHidden());
        QrCodeEntity qrCodeEntity = qrCodeService.generateWifiQrCode(content, imageType.getValue());

        return ResponseEntity.ok()
                .contentType(imageType.getMimeType())
                .body(qrCodeEntity.getImage());
    }

    @PostMapping("/url")
    public ResponseEntity<byte[]> generateUrlQr(@Valid @RequestBody UrlRequestDTO urlRequest) throws IOException, WriterException {
        RequestImageType imageType = urlRequest.getValidatedImageType();
        QrCodeEntity qrCodeEntity = qrCodeService.generateUrlQrCode(urlRequest.getUrl(), imageType.getValue());

        return ResponseEntity.ok()
                .contentType(imageType.getMimeType())
                .body(qrCodeEntity.getImage());
    }
}