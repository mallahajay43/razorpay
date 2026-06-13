package me.mallahajay43.razorpay.payment.entity;

import jakarta.persistence.*;
import me.mallahajay43.razorpay.common.enums.PaymentActor;
import me.mallahajay43.razorpay.common.enums.PaymentEvent;
import me.mallahajay43.razorpay.common.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_transition_log")
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PaymentStatus toStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PaymentEvent paymentEvent;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PaymentActor paymentActor;

    @Column(nullable = false)
    private LocalDateTime occurredAt;
}
