package com.schratter.qrcodegeneratorcore;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class QrCodeGenerator {

    private QrCodeGenerator() {
    }

    public static byte[] generate(String content, String imageFormat) throws IOException, WriterException {
        return generateQrCode(content, 300, 300, imageFormat);
    }

    public static byte[] generate(String content, int width, int height, String imageFormat) throws WriterException, IOException {
        return generateQrCode(content, width, height, imageFormat);
    }

    private static byte[] generateQrCode(String content, int width, int height, String imageFormat) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);

        if (imageFormat.equalsIgnoreCase("svg")) {
            return SvgQrCodeWriter.toSvg(matrix);
        } else {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, imageFormat, stream);
            return stream.toByteArray();
        }
    }
}