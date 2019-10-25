package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Transaction {
    String date;
    String from;
    String to;
    String narrative;
    Double amount;

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public Transaction (String singleTrans) {
        String[] parts = singleTrans.split(",");
        try {
            date = parts[0];
            from = parts[1];
            to = parts[2];
            narrative = parts[3];
            amount = Double.valueOf(parts[4]);
        } catch (Exception e) {
            LOGGER.error("data doesn't fit Transaction class when creating objects, ref:" + singleTrans + " " + e);
        }
    }

    @Override
    public String toString () {
        String stupid = "\n" + date + " " + from + " " + to + " " + narrative + " " + amount;
        return stupid;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getNarrative() {
        return narrative;
    }

    public Double getAmount() {
        return amount;
    }
}
