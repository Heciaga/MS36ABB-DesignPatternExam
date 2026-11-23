package az.ingress.task3.Version2.adapter;

public enum Currency {
    AZN(1.00),
    USD(1.70);

    private final double aznRate;

    Currency(double aznRate) {
        this.aznRate = aznRate;
    }

    public double fromAzn(double amountAzn) {
        return amountAzn / aznRate;
    }

    public double toAzn(double amount) {
        return amount * aznRate;
    }
}
