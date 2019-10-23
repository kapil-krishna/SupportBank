package training.supportbank;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String args[]) throws IOException {

        //read the file and contain it as a list of strings
        Path filePath = Paths.get("resources/Transactions2014.csv");
        List<String> lines = Files.readAllLines(filePath);

        //create a new list called "transactions"
        List<Transaction> transactions = new ArrayList<>();

        for (String line : lines) {
            transactions.add(new Transaction(line));
        }


        System.out.println("Test!");
    }
}
