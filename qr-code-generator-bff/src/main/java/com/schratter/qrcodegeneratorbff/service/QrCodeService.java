package com.schratter.qrcodegeneratorbff.service;

import com.google.zxing.WriterException;
import com.schratter.qrcodegeneratorbff.model.dto.url.UrlRequestDTO;
import com.schratter.qrcodegeneratorbff.model.dto.wifi.WifiRequestDTO;
import com.schratter.qrcodegeneratorcore.QrCodeGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QrCodeService {

    public byte[] generateWifiQrCode(WifiRequestDTO wifiRequest) throws IOException, WriterException {
        String content = String.format("WIFI:T:%s;S:%s;P:%s;H:%s;;", wifiRequest.getEncryption(), wifiRequest.getSsid(), wifiRequest.getPassword(), wifiRequest.isHidden());
        return QrCodeGenerator.generate(content, 300, 300, wifiRequest.getImageType());
    }

    public byte[] generateUrlQrCode(UrlRequestDTO urlRequest) throws IOException, WriterException {
        return QrCodeGenerator.generate(urlRequest.getUrl(), 300, 300, urlRequest.getImageType());
    }
}