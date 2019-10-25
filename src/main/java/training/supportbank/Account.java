package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    List<Transaction> fromTransactions = new ArrayList<>();
    List<Transaction> toTransactions = new ArrayList<>();
    Double balance = 0.0;

    public Account(String blah, List<Transaction> allTransactions) {
        for (Transaction item : allTransactions) {
            try {
                if (blah.equals(item.getFrom())) {
                    fromTransactions.add(item);
                    balance += item.getAmount();
                }
                if (blah.equals(item.getTo())) {
                    toTransactions.add(item);
                    balance -= item.getAmount();
                }
            } catch (Exception e) {
                LOGGER.error("Could not add/subtract " + item.getAmount() + " to balance" + e);
                throw e;
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

