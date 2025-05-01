package com.schratter.qrcodegeneratorcore;

import com.google.zxing.common.BitMatrix;

import java.nio.charset.StandardCharsets;

public class SvgQrCodeWriter {

    public static byte[] toSvg(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        StringBuilder svg = new StringBuilder();
        svg.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" ")
                .append("width=\"").append(width).append("\" height=\"").append(height).append("\">\n")
                .append("<rect width=\"100%\" height=\"100%\" fill=\"white\"/>\n")
                .append("<g fill=\"black\">\n");

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    svg.append("<rect x=\"").append(x)
                            .append("\" y=\"").append(y)
                            .append("\" width=\"1\" height=\"1\" />\n");
                }
            }
        }

        svg.append("</g>\n</svg>");
        return svg.toString().getBytes(StandardCharsets.UTF_8);
    }
}