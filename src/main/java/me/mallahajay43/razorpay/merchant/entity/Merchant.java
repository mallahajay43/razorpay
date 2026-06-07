package me.mallahajay43.razorpay.merchant.entity;

import jakarta.persistence.*;
import me.mallahajay43.razorpay.common.enums.BusinessType;
import me.mallahajay43.razorpay.common.enums.MerchantStatus;

import java.util.UUID;

@Entity
@Table(name = "merchants")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 200)
    private String businessName;

    @Column(length = 20)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Enumerated(EnumType.STRING)
    private MerchantStatus status = MerchantStatus.PENDING_KYC;

    @Column(length = 200)
    private String websiteUrl;

    @Column(length = 20)
    private String gstId;

    @Column(length = 20)
    private String panId;

    @Column(length = 200)
    private String settlementBankAccount;

    @Column(length = 20)
    private String settlementIfsc;

    @Column(length = 200)
    private String settlementAccountHolderName;
}
