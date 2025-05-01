package com.schratter.qrcodegeneratorbff.model.dto;


import com.schratter.qrcodegeneratorbff.exception.InvalidImageTypeException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class QrCodeRequestDTO {

    @NotNull(message = "Image type must not be null")
    @NotBlank(message = "Image type must not be blank")
    @Schema(description = "Image type to generate", allowableValues = {"PNG", "JPG"})
    private String imageType;

    public RequestImageType getValidatedImageType() {
        try {
            return RequestImageType.fromString(imageType); // throws if invalid
        } catch (IllegalArgumentException _) {
            throw new InvalidImageTypeException(imageType);
        }
    }
}