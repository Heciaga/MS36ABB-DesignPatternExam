package az.ingress.task3.Version2.adapter;

import az.ingress.task3.Version2.PaymentGateway;
import az.ingress.task3.Version2.sdk.EasyPaySdk;

import java.math.BigDecimal;

public class EasyPaAdapter implements PaymentGateway {
    private EasyPaySdk sdk;

    public EasyPaAdapter(EasyPaySdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public boolean pay(String card, double amountAzn) {
        try {
            sdk.makePayment(BigDecimal.valueOf(amountAzn), "AZN", card);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
