package az.ingress.task3.Version2;

public interface PaymentGateway {
    boolean pay(String card, double amountAzn);
}
