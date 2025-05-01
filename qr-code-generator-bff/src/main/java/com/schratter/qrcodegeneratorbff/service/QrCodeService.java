package com.schratter.qrcodegeneratorbff.service;

import com.schratter.qrcodegeneratorbff.model.WifiRequest;
import com.schratter.qrcodegeneratorcore.QrCodeGenerator;
import org.springframework.stereotype.Service;

@Service
public class QrCodeService {

    public byte[] generateWifiQrCode(WifiRequest wifi) throws Exception {
        String content = String.format("WIFI:T:%s;S:%s;P:%s;H:%s;;",
                wifi.getEncryption(), wifi.getSsid(), wifi.getPassword(), wifi.isHidden());

        return QrCodeGenerator.generate(content);
    }
}