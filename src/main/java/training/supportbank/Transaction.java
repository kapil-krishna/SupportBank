package training.supportbank;

public class Transaction {
    String date;
    String from;
    String to;
    String narrative;
    Double amount;

    public Transaction (String singleTrans) {
        String[] parts = singleTrans.split(",");
        date = parts[0];
        from = parts[1];
        to = parts[2];
        narrative = parts[3];
        amount = Double.valueOf(parts[4]);
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
