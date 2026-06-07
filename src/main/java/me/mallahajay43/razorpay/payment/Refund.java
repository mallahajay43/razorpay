package me.mallahajay43.razorpay.payment;

import jakarta.persistence.*;
import me.mallahajay43.razorpay.common.entity.Money;
import me.mallahajay43.razorpay.common.enums.RefundStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "refund")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Payment payment;

    @Column(nullable = false)
    private UUID merchantId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RefundStatus refundStatus;

    @Column(length = 100)
    private String bankReference;
    @Column(length = 50)
    private String errorCode;
    @Column(length = 256)
    private String errorDescription;
    private LocalDateTime processedAt;
}
