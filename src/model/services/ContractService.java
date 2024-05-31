package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {


    private  OnlinePaymentServices services;

    public ContractService(OnlinePaymentServices services) {
        this.services = services;
    }

    public void processContract(Contract contract, Integer months) {
        double cutValue = contract.getTotalValue() / months;

        for (int i=1; i <= months; i++) {
            LocalDate monthCount = contract.getDate().plusMonths(i);
            double interest = services.interest(cutValue, i);
            double fee = services.paymentFee(cutValue + interest);
            double value = cutValue + interest + fee;
            contract.getInstallments().add(new Installment(monthCount, value));
        }
    }
}
