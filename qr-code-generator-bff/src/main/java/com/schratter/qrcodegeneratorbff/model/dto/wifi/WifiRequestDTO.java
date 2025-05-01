package com.schratter.qrcodegeneratorbff.model.dto.wifi;

import com.schratter.qrcodegeneratorbff.model.dto.QrCodeRequestDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class WifiRequestDTO extends QrCodeRequestDTO {

    @NotNull(message = "SSID must not be null")
    @NotBlank(message = "SSID must not be blank")
    private String ssid;

    private String password;

    @NotNull(message = "Encryption must not be null")
    @NotBlank(message = "Encryption must not be blank")
    private String encryption;

    @NotNull
    private boolean hidden;

}