package com.schratter.qrcodegeneratorbff.model.dto.url;

import com.schratter.qrcodegeneratorbff.model.dto.QrCodeRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UrlRequestDTO extends QrCodeRequestDTO {

    @NotNull(message = "Url must not be null")
    @NotBlank(message = "Url must not be blank")
    private String url;

}