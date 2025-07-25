package com.schratter.qrcodegeneratorservice.dao.repository;

import com.schratter.qrcodegeneratorservice.dao.entity.QrCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCodeEntity, Long> {
}