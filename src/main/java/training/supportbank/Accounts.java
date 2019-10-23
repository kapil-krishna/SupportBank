package training.supportbank;

import java.util.List;

public class Account {
    String name;
    List<Transaction> fromTransactions;
    List<Transaction> toTransactions;

    calculateSum() {
        Double amountOut = 0.0;
        for (toTransactions : Transaction) {
            amountOut += toTransactions.amount;
        }
        for (fromTransactions : Transaction) {
            amountOut -= fromTransactions.amount;
        }
    }
}
