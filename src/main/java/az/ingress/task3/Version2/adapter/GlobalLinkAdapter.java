package az.ingress.task3.Version2.adapter;

import az.ingress.task3.Version2.PaymentGateway;
import az.ingress.task3.Version2.sdk.GlobalPaySdk;

public class GlobalLinkAdapter implements PaymentGateway {
    private final GlobalPaySdk sdk;

    public GlobalLinkAdapter(GlobalPaySdk sdk) {
        this.sdk = sdk;
    }

    @Override
    public boolean pay(String card, double amountAzn) {
        double amount = Currency.USD.fromAzn(amountAzn);
        String result = sdk.process(amount, card);
        return result.equals("OK");
    }
}
