package com.schratter.qrcodegeneratorbff.model.dto.wifi;

import lombok.Getter;

@Getter
public enum WifiRequestImageTypeDTO {
    PNG("PNG"),
    JPG("JPG");

    private final String value;

    WifiRequestImageTypeDTO(String value) {
        this.value = value;
    }

    public static WifiRequestImageTypeDTO fromString(String type) {
        for (WifiRequestImageTypeDTO wfi : values()) {
            if (wfi.name().equalsIgnoreCase(type)) {
                return wfi;
            }
        }
        throw new IllegalArgumentException("Unsupported image type: " + type);
    }
}