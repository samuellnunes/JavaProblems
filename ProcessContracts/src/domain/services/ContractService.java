package domain.services;

import domain.entities.Contract;
import domain.entities.Installment;

import java.time.LocalDate;

public class ContractService {

   private OnlinePaymentService onlinePaymentService;

   public ContractService() {

   }

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

       double basicQuota = contract.getTotalValue() / months;

       for (int i = 1; i <= months; i++) {
           LocalDate dueDate = contract.getDate().plusMonths(i);

           double interest = onlinePaymentService.interest(basicQuota, i);
           double fee = onlinePaymentService.paymentFee(basicQuota + interest);

           double quota = interest + fee + basicQuota;

           contract.getInstallments().add(new Installment(dueDate, quota));
       }
    }
}
