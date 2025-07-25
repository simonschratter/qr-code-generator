package com.schratter.qrcodegeneratorservice.service;

import com.google.zxing.WriterException;
import com.schratter.qrcodegeneratorcore.QrCodeGenerator;
import com.schratter.qrcodegeneratorservice.dao.entity.QrCodeEntity;
import com.schratter.qrcodegeneratorservice.dao.repository.QrCodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;

    public QrCodeService(QrCodeRepository qrCodeRepository) {
        this.qrCodeRepository = qrCodeRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public QrCodeEntity generateWifiQrCode(String content, String imageType) throws IOException, WriterException {
        byte[] image = QrCodeGenerator.generate(content, imageType);
        return saveQrCode(content, image);
    }

    @Transactional(rollbackFor = Exception.class)
    public QrCodeEntity generateUrlQrCode(String content, String imageType) throws IOException, WriterException {
        byte[] image = QrCodeGenerator.generate(content, 300, 300, imageType);
        return saveQrCode(content, image);
    }

    public QrCodeEntity saveQrCode(String content, byte[] imageUrl) {
        QrCodeEntity qrCode = new QrCodeEntity(content, imageUrl);
        return qrCodeRepository.save(qrCode);
    }
}