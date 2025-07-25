package com.schratter.qrcodegeneratorservice.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "qr_code")
@Data
public class QrCodeEntity {

    public QrCodeEntity() {
    }

    public QrCodeEntity(String content, byte[] image) {
        this.content = content;
        this.image = image;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private byte[] image;

    @Column(nullable = false)
    private Timestamp createdAt;

}