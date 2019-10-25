package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.nio.file.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    //create method for List [Account]
    private static void listTransactions(Map<String, Account> someMap) {
        Scanner askName = new Scanner(System.in);
        String accountName;
        System.out.println("Enter an account name");
        accountName = askName.nextLine();
        System.out.println((someMap.get(accountName)).getFromTransactions());
        System.out.println((someMap.get(accountName)).getToTransactions());
    }

    //create method for List All
    private static void balanceOwed(Map<String, Double> someMap) {
        System.out.println(someMap);
    }

    private static void options(String someString, Map<String, Double> someMap, Map<String, Account> anotherMap) {
        if (someString.equals("List All")) {
            balanceOwed(someMap);
        }
        if (someString.equals("List [Account]")) {
            listTransactions(anotherMap);
        }
    }

    //MAIN
    public static void main(String args[]) throws IOException {

        LOGGER.info("Beginning of main code");

        //read the file and contain it as a list of strings
        Path filePath1 = Paths.get("resources/Transactions2014.csv");
        List<String> lines = Files.readAllLines(filePath1);
        Path filePath2 = Paths.get("resources/DodgyTransactions2015.csv");
        lines.addAll(Files.readAllLines(filePath2));
        LOGGER.info("File read successfully");

        //create a new list called "allTransactions"
        List<Transaction> allTransactions = new ArrayList<>();

        //for loop to iterate on each line of transactions
        for (String line : lines) {
            int lineNum = lines.indexOf(line);
                //create an empty object of transaction class
            try {
                Transaction t = new Transaction(line);
                //push the object into the "transactions" list
                allTransactions.add(t);
            } catch (Exception e) {
                LOGGER.error(String.format("Failed to create transaction object from string %s on line number %d. Error was %s", line, lineNum, e));
                continue;
            }
        }
        LOGGER.info("Created list of transaction objects");

        //now "allTransactions" is a list of Transaction objects!

        //get a list of names
        List<String> names = new ArrayList<>();
        for (int i = 0; i < allTransactions.size(); i++) {
            if (!(names.contains(allTransactions.get(i).from))) {
                names.add(allTransactions.get(i).from);
            }
        }
        LOGGER.info("Created list of names");

        //create two empty hashmaps, one with a list of accounts with transactions
        //and one with a list of accounts with balances
        Map<String, Account> listOfAcc = new HashMap<String, Account>();
        Map<String, Double> balanceList = new HashMap<String, Double>();
        for (String name : names) {
            Account holder = new Account(name, allTransactions);
            listOfAcc.put(name, holder);
            balanceList.put(name, listOfAcc.get(name).getBalance());
        }
        LOGGER.info("Hashmaps created successfully");

        LOGGER.info("End of main code");

        //program starts here
        LOGGER.info("Beginning of program");
        Scanner intro = new Scanner(System.in);
        System.out.println(
                "Welcome to the bank of Softwire! Type List All to find out how much everyone owes. " +
                        "Type List [Account] to get all the transactions for a particular person.");
        String userOption = intro.nextLine();
        while (!(userOption.equals("List All") || userOption.equals("List [Account]"))) {
            Scanner repeat = new Scanner(System.in);
            System.out.println("That is not one of the commands I know. Please Type List All or List [Account].");
            userOption = repeat.nextLine();
        }
        options(userOption, balanceList, listOfAcc);

        LOGGER.info("End of program");
    }
}




