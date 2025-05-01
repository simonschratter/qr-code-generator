package com.schratter.qrcodegeneratorbff.model.dto.wifi;

import com.schratter.qrcodegeneratorbff.exception.InvalidImageTypeException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WifiRequestDTO {

    @NotNull(message = "SSID must not be null")
    private String ssid;

    private String password;

    @NotNull(message = "Encryption must not be null")
    private String encryption;

    @NotNull
    private boolean hidden;

    @NotNull(message = "Image type must not be null")
    @Schema(description = "Image type to generate", allowableValues = {"PNG", "JPG"})
    private String imageType;

    public WifiRequestImageTypeDTO getValidatedImageType() {
        try {
            return WifiRequestImageTypeDTO.fromString(imageType); // throws if invalid
        } catch (IllegalArgumentException _) {
            throw new InvalidImageTypeException(imageType);
        }
    }
}