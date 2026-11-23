package az.ingress.task3.Version2.adapter;

import az.ingress.task3.Version2.PaymentGateway;
import az.ingress.task3.Version2.sdk.PayLinkSdk;

public class PayLinkAdapter implements PaymentGateway {
    private final PayLinkSdk sdk;
    public PayLinkAdapter(PayLinkSdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public boolean pay(String card, double amountAzn) {
        long qapik = Math.round(amountAzn * 100);
        return sdk.charge(card, qapik) == 0;
    }
}
