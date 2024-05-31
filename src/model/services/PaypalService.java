package model.services;

public class PaypalService implements OnlinePaymentServices{

    public static final Double INTEREST_MONTH = 0.01;
    public static final Double SIMPLE_FEE = 0.02;

    @Override
    public Double paymentFee(Double amount) {
        return amount * SIMPLE_FEE;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * INTEREST_MONTH * months;
    }
}
