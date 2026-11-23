package az.ingress.task3.Version2.sdk;

import java.math.BigDecimal;

public class EasyPaySdk {
    public void makePayment(BigDecimal amount, String currency, String card) {
        System.out.println("   EasyPay: " + amount + " " + currency);
        if (amount.compareTo(new BigDecimal("2000")) > 0) {
            throw new IllegalStateException("Limit exceeded");
        }
    }
}
