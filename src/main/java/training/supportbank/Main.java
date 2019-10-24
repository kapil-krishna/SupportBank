package training.supportbank;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
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
            //create an empty object of transaction class
            Transaction t = new Transaction(line);
            //push the object into the "transactions" list
            allTransactions.add(t);
        }
        //now "allTransactions" is a list of Transaction objects


        //CALCULATE THE SUM OF MONEY OWED
        //get a list of names
        List<String> names = new ArrayList<>();
        for (int i = 0; i < allTransactions.size(); i++) {
            if (!(names.contains(allTransactions.get(i).from))) {
                names.add(allTransactions.get(i).from);
            }
        }
//        System.out.println(names);
//        //get a list of amounts owed
//        List<Double> amountOwed = new ArrayList<>();
//        for (int i = 0; i < names.size(); i++) {
//            Double owed = 0.0;
//            for (int j = 0; j < allTransactions.size(); j++) {
//                if (allTransactions.get(j).from.equals(names.get(i))) {
//                    owed += (allTransactions.get(j).amount);
//                }
//                if (allTransactions.get(j).to.equals(names.get(i))) {
//                    owed -= allTransactions.get(j).amount;
//                }
//            }
//            amountOwed.add(owed);
//        }
//        System.out.println(amountOwed);
//        //print list

        Map<String, Account> listOfAcc = new HashMap<String, Account>();
        Map<String, Double> balanceList = new HashMap<String, Double>();
        for (String name : names) {
            Account holder = new Account(name, allTransactions);
            listOfAcc.put(name, holder);
            balanceList.put(name, listOfAcc.get(name).getBalance());
        }

//        public static void listTrasactions() {
        Scanner askName = new Scanner(System.in);
        String accountName;
        System.out.println("Enter account name");
        accountName = askName.nextLine();
        System.out.println((listOfAcc.get(accountName)).getFromTransactions());
        System.out.println((listOfAcc.get(accountName)).getToTransactions());

//        }
//        public static void balanceOwed() {
        System.out.println(balanceList);
    }
}
//

