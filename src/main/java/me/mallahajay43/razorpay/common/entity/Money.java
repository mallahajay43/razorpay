package me.mallahajay43.razorpay.common.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Money {

    private final int amountUnits;
    private final String currency;

    private Money(int amountUnits, String currency) {
        this.amountUnits = amountUnits;
        this.currency = currency;
    }

    public static Money of(int amountUnits, String currency) {
        return new Money(amountUnits, currency);
    }

    public static Money inr(int amountUnits) {
        return new Money(amountUnits, "INR");
    }

    public Money add(Money other) {
        if (this.currency.equals(other.currency)) {
            return new Money(this.amountUnits + other.amountUnits, this.currency);
        } else {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
    }

    public Money subtract(Money other) {
        if (this.currency.equals(other.currency)) {
            return new Money(this.amountUnits - other.amountUnits, this.currency);
        } else {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
    }
}
