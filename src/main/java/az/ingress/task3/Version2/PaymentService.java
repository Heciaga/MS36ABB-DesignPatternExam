package az.ingress.task3.Version2;

import az.ingress.task3.Version2.adapter.EasyPaAdapter;
import az.ingress.task3.Version2.adapter.GlobalLinkAdapter;
import az.ingress.task3.Version2.adapter.PayLinkAdapter;
import az.ingress.task3.Version2.sdk.EasyPaySdk;
import az.ingress.task3.Version2.sdk.GlobalPaySdk;
import az.ingress.task3.Version2.sdk.PayLinkSdk;

import java.util.List;
import java.util.Map;

public class PaymentService {
    private final Map<String, PaymentGateway> gateways;


    public PaymentService(Map<String, PaymentGateway> gateways) {
        this.gateways = gateways;
    }

    public PaymentService() {
        this(Map.of(
                "PAYLINK", new PayLinkAdapter(new PayLinkSdk()),
                "EASYPAY", new EasyPaAdapter(new EasyPaySdk()),
                "GLOBALPAY", new GlobalLinkAdapter(new GlobalPaySdk())
        ));
    }

    public boolean pay(String provider, String card, double amountAzn) {
        PaymentGateway gateway = gateways.get(provider);
        if (gateway == null) {
            throw new IllegalArgumentException("Unknown provider: " + provider);
        }
        return gateway.pay(card, amountAzn);
    }

    record Payment(String provider, String card, double amountAzn) {
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        List<Payment> payments = List.of(
                new Payment("PAYLINK", "4169-1111", 150),
                new Payment("PAYLINK", "4169-1111", 1500),
                new Payment("EASYPAY", "5522-2222", 300),
                new Payment("EASYPAY", "5522-2222", 2500),
                new Payment("GLOBALPAY", "4098-3333", 340),
                new Payment("GLOBALPAY", "4098-3333", 1870)
        );

        for (Payment p : payments) {
            boolean ok = service.pay(p.provider(), p.card(), p.amountAzn());
            System.out.println(p.provider() + " " + p.amountAzn() + " AZN -> " + (ok ? "SUCCESS" : "FAILED"));
        }
    }

}
