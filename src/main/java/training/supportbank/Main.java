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
        //now "allTransactions" is a list of Transaction objects!

        //get a list of names
        List<String> names = new ArrayList<>();
        for (int i = 0; i < allTransactions.size(); i++) {
            if (!(names.contains(allTransactions.get(i).from))) {
                names.add(allTransactions.get(i).from);
            }
        }
        //create two empty hashmaps, one with a list of accounts with transactions
        //and one with a list of accounts with balances
        Map<String, Account> listOfAcc = new HashMap<String, Account>();
        Map<String, Double> balanceList = new HashMap<String, Double>();
        for (String name : names) {
            Account holder = new Account(name, allTransactions);
            listOfAcc.put(name, holder);
            balanceList.put(name, listOfAcc.get(name).getBalance());
        }

        //create a method for List [Account]
        //static void listTransactions() {
            Scanner askName = new Scanner(System.in);
            String accountName;
            System.out.println("Enter an account name");
            accountName = askName.nextLine();
            System.out.println((listOfAcc.get(accountName)).getFromTransactions());
            System.out.println((listOfAcc.get(accountName)).getToTransactions());
        //}

        //create a method for List All
        //static void balanceOwed() {
            System.out.println(balanceList);
        //}

//        Scanner intro = new Scanner(System.in);
//        System.out.println(
//                "Welcome to the bank of Softwire! Type List All to find out how much everyone owes. " +
//                        "Type List [Account] to get all the transactions for a particular person.")
//        String userOption = intro.nextLine();
//        options(userOption);
//
//        //create method for asking options
//        public static void options (userOption) {
//        if (userOption == "List All") {
//            balanceOwed();
//        }
//        if (userOption == "List [Account]") {
//            listTransactions();
//        } else {
//            Scanner repeat = new Scanner(System.in);
//            System.out.println("That is not one of the commands I know. Please Type List All or List [Account]");
//            userOption = repeat.nextLine();
//        }
    }
}



