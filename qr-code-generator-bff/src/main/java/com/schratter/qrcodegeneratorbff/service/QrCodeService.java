package com.schratter.qrcodegeneratorbff.service;

import com.google.zxing.WriterException;
import com.schratter.qrcodegeneratorbff.model.dto.wifi.WifiRequestDTO;
import com.schratter.qrcodegeneratorbff.model.dto.wifi.WifiRequestImageTypeDTO;
import com.schratter.qrcodegeneratorcore.QrCodeGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QrCodeService {

    public byte[] generateWifiQrCode(WifiRequestDTO wifi) throws IOException, WriterException {
        WifiRequestImageTypeDTO imageType = wifi.getValidatedImageType();
        String content = String.format("WIFI:T:%s;S:%s;P:%s;H:%s;;",
                wifi.getEncryption(), wifi.getSsid(), wifi.getPassword(), wifi.isHidden());

        return QrCodeGenerator.generate(content, imageType.getValue());
    }
}