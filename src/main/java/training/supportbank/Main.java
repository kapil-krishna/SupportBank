package training.supportbank;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.nio.file.*;

public class Main {
    public static void main(String args[]) throws IOException {

        //read the file and contain it as a list of strings
        Path filePath = Paths.get("resources/Transactions2014.csv");
        List<String> lines = Files.readAllLines(filePath);

        //create a new list called "transactions"
        List<Transaction> allTransactions = new ArrayList<>();

        //for loop to iterate on each line of transactions
        for (String line : lines) {
            //create array that splits the string into it's individual parts
            String[] parts = line.split(",");
            //create an empty object of transaction class
            Transaction t = new Transaction();
            //apply each element of the array into the the object
            t.date = parts[0];
            t.from = parts[1];
            t.to = parts[2];
            t.narrative = parts[3];
            t.amount = Double.valueOf(parts[4]);
            //push the object into the "transactions" list
            allTransactions.add(t);
        }

        //CALCULATE THE SUM OF MONEY OWED
        //get a list of names
        List<String> names = new ArrayList<>();
        for (int i = 0; i < allTransactions.size(); i++) {
            if (!(names.contains(allTransactions.get(i).from))) {
                names.add(allTransactions.get(i).from);
            }
        }
        System.out.println(names);
        //get a list of amounts owed
        List<Double> amountOwed = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Double owed = 0.0;
            for (int j = 0; j < allTransactions.size(); j++) {
                if (allTransactions.get(j).from.equals(names.get(i))) {
                    owed += (allTransactions.get(j).amount);
                }
                if (allTransactions.get(j).to.equals(names.get(i))) {
                    owed -= allTransactions.get(j).amount;
                }
            }
            amountOwed.add(owed);
        }
        System.out.println(amountOwed);
        //print list


    }
}
