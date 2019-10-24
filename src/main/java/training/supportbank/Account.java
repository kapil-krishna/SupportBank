package training.supportbank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    List<Transaction> fromTransactions = new ArrayList<>();
    List<Transaction> toTransactions = new ArrayList<>();
    Double balance = 0.0;

    public Account(String blah, List<Transaction> allTransactions) {
        for (Transaction item : allTransactions) {
            if (blah.equals(item.getFrom())) {
                fromTransactions.add(item);
                balance += item.getAmount();
            }
            if (blah.equals(item.getTo())) {
                toTransactions.add(item);
                balance -= item.getAmount();
            }
        }
    }

    public List<Transaction> getFromTransactions() {
        return fromTransactions;
    }

    public List<Transaction> getToTransactions() {
        return toTransactions;
    }

    public Double getBalance() {
        return balance;
    }
}

