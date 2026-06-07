package me.mallahajay43.razorpay.merchant.entity;

import jakarta.persistence.*;
import me.mallahajay43.razorpay.common.enums.Environment;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "api_key")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Merchant merchant;

    @Column(unique = true, nullable = false, length = 50)
    private String keyId;

    @Column(nullable = false, length = 200)
    private String keySecretHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Environment environment;

    @Column(nullable = false)
    private Boolean enabled;

    private LocalDateTime lastUsedAt;
    private LocalDateTime rotatedAt;
    private LocalDateTime gracePeriodExpiredAt;
}
