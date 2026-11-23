package az.ingress.task3.Version2.sdk;

import az.ingress.task3.Version2.PaymentGateway;

public class PayLinkSdk {
    public int charge(String card, long amount) {
        System.out.println("   PayLink: " + amount + " qapik");
        return amount <= 100_000 ? 0 : 51;
    }

}
