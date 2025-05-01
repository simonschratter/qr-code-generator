package com.schratter.qrcodegeneratorcore;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QrCodeGenerator {

    private QrCodeGenerator() {}

    public static byte[] generate(String qrContent, String format) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(qrContent, BarcodeFormat.QR_CODE, 300, 300);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, format, stream);
        return stream.toByteArray();
    }
}