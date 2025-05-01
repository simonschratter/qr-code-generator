package com.schratter.qrcodegeneratorbff.model.dto;

import lombok.Getter;
import org.springframework.http.MediaType;

@Getter
public enum RequestImageType {
    PNG("PNG", MediaType.IMAGE_PNG),
    JPG("JPG", MediaType.parseMediaType("image/jpeg")),
    SVG("SVG", MediaType.parseMediaType("image/svg+xml"));

    private final String value;
    private final MediaType mimeType;

    RequestImageType(String value, MediaType mimeType) {
        this.value = value;
        this.mimeType = mimeType;
    }

    public static RequestImageType fromString(String type) {
        for (RequestImageType wfi : values()) {
            if (wfi.name().equalsIgnoreCase(type)) {
                return wfi;
            }
        }
        throw new IllegalArgumentException("Unsupported image type: " + type);
    }
}