package com.schratter.qrcodegeneratorbff.model;

import lombok.Data;

@Data
public class WifiRequest {
    private String ssid;
    private String password;
    private String encryption;
    private boolean hidden;
}