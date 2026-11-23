package az.ingress.task3.Version2.sdk;

public class GlobalPaySdk {
    public String process(double amountUsd, String card) {
        System.out.println("   GlobalPay: " + String.format("%.2f", amountUsd) + " USD");
        return amountUsd <= 1000 ? "OK" : "DECLINED";
    }
}
