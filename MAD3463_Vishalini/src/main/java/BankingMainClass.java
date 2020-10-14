import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.CheckingAccount;
import domain.ClientDetails;
import domain.SavingsAccount;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BankingMainClass {


    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.home") + "/Desktop/MAD3463");
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        File savingsAccount = new File(System.getProperty("user.home") + "/Desktop/MAD3463/SavingsAccount.txt");
        File checkingAccount = new File(System.getProperty("user.home") + "/Desktop/MAD3463/CheckingAccount.txt");
        File clientDetails = new File(System.getProperty("user.home") + "/Desktop/MAD3463/ClientDetails.txt");

        if (savingsAccount.createNewFile()) {
            System.out.println("File created: " + savingsAccount.getName());
        } else {
            System.out.println(savingsAccount.getName() + " File already exists.");
        }
        if (checkingAccount.createNewFile()) {
            System.out.println("File created: " + checkingAccount.getName());
        } else {
            System.out.println(checkingAccount.getName() + " File already exists.");
        }
        if (clientDetails.createNewFile()) {
            System.out.println("File created: " + clientDetails.getName());
        } else {
            System.out.println(clientDetails.getName() + " File already exists.");
        }

        operationMenu();
    }
public static void operationMenu() throws IOException {
    Scanner scan = new Scanner(System.in);

    System.out.println("Select any one of the following actions");
    System.out.println("Press 1 to create bank accounts for the client");
    System.out.println("Press 2 to display current balance");
    System.out.println("Press 3 to deposit money");
    System.out.println("Press 4 to draw money");
    System.out.println("Press 5 to transfer money to other accounts within the bank");
    System.out.println("Press 6 to pay utility bills");
    int choice = scan.nextInt();

    if (choice == 1) {
        createBankAccount();
    } else if (choice == 2) {
        displayCurrentBalance();
    }else if(choice==3){
        depositMoney();
    }else if(choice==4){
        drawMoney();
    }else if(choice==5){
        transferMoney();
    }else if(choice==6){
        payUtilityBills();
    }
}
    public static void createBankAccount() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner scan = new Scanner(System.in);
        ClientDetails clientDetails = new ClientDetails();
        System.out.println("Please enter Client Name");
        clientDetails.setClientName(scan.next());
        System.out.println("Please enter Client Address");
        clientDetails.setAddress(scan.next());
        File file = new File(System.getProperty("user.home") +
                "/Desktop/MAD3463/ClientDetails.txt");
        if(!FileUtils.readFileToString(file).contains(clientDetails.getClientName())){
            FileOutputStream fOut = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            BufferedWriter bw = new BufferedWriter(osw);
            System.out.println(file.length()+" file length");
            if(file.length()!=0){
                bw.newLine();
            }
            bw.write(mapper.writeValueAsString(clientDetails));
            bw.flush();
            bw.close();
        }
        System.out.println("Select the type of bank account to open");
        System.out.println("Press 1 to create Savings account");
        System.out.println("Press 2 to create Checking account");

        int choice = scan.nextInt();

        if (choice == 1) {
            createSavingsAccount(clientDetails);
        } else if (choice == 2) {
            createCheckingAccount(clientDetails);
        }

        operationMenu();
    }

    public static void createSavingsAccount(ClientDetails clientDetails) throws IOException {
        Scanner scan = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        Random rand = new Random();
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber(rand.nextInt(100000));
        savingsAccount.setAccountName(clientDetails.getClientName());
        savingsAccount.setAddress(clientDetails.getAddress());
        System.out.println("Please enter the savings interest rate");
        savingsAccount.setSavingsInterestRate(scan.nextDouble());
        System.out.println("Please enter the savings balance");
        savingsAccount.setSavingsBalance(scan.nextDouble());
        File file = new File(System.getProperty("user.home") +
                "/Desktop/MAD3463/SavingsAccount.txt");
        FileOutputStream fOut = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        BufferedWriter bw = new BufferedWriter(osw);
        if(file.length()!=0){
            bw.newLine();
        }
        bw.write(mapper.writeValueAsString(savingsAccount));
        bw.flush();
        operationMenu();
    }

    public static void createCheckingAccount(ClientDetails clientDetails) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setAccountNumber(rand.nextInt(100000));
        checkingAccount.setAccountName(clientDetails.getClientName());
        checkingAccount.setAddress(clientDetails.getAddress());
        System.out.println("Please enter the checking balance");
        checkingAccount.setCheckingBalance(scan.nextDouble());
        File file = new File(System.getProperty("user.home") +
                "/Desktop/MAD3463/CheckingAccount.txt");
        FileOutputStream fOut = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        BufferedWriter bw = new BufferedWriter(osw);
        System.out.println(file.length()+" file length");
        if(file.length()!=0){
            bw.newLine();
        }
        bw.write(mapper.writeValueAsString(checkingAccount));
        bw.flush();
        bw.close();
        operationMenu();
    }

 /*   public static void createCreditAccount(ClientDetails clientDetails) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter the client account name");
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setAccountNumber(rand.nextInt(100000));
        creditAccount.setAccountName(clientDetails.getClientName());
        creditAccount.setAddress(clientDetails.getAddress());
        System.out.println("Please enter the credit limit");
        creditAccount.setCreditLimit(scan.nextDouble());
        System.out.println("Please enter the credit pending balance");
        creditAccount.setCreditLimit(scan.nextDouble());
        File file = new File(System.getProperty("user.home") +
                "/Desktop/MAD3463/CreditAccount.txt");
        FileOutputStream fOut = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        osw.write(mapper.writeValueAsString(creditAccount));
        osw.flush();
        osw.close();
    }*/

    public static void displayCurrentBalance() throws IOException {
        ArrayList<ClientDetails> clientDetails = new ArrayList<ClientDetails>();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
        ObjectMapper mapper = new ObjectMapper();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select the client name below");

        try {
            File myObj = new File
                    (System.getProperty("user.home") + "/Desktop/MAD3463/ClientDetails.txt");
            Scanner myReader = new Scanner(myObj);

            try (BufferedReader br = new BufferedReader(new FileReader(myObj))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    ClientDetails details = mapper.readValue(line, ClientDetails.class);
                    System.out.println(details.getClientName());
                    clientDetails.add(mapper.readValue(line, ClientDetails.class));
                }
            }

//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                System.out.println(data);
//                ClientDetails details = mapper.readValue(data, ClientDetails.class);
//                System.out.println(details.getClientName());
//                clientDetails.add(mapper.readValue(data, ClientDetails.class));
//            }
//            myReader.close();

            String clientName = scan.next();
            System.out.println("Please select the account type for the balance");
            System.out.println("Please enter 1 for savings account");
            System.out.println("Please enter 2 for checking account");

            int accountType = scan.nextInt();
            String account = null;
            System.out.println(accountType);
            if (accountType == 1) {
                account = "SavingsAccount";
            } else if (accountType == 2) {
                account = "CheckingAccount";
            }

            File accountDetailsFile = new File
                    (System.getProperty("user.home") + "/Desktop/MAD3463/" + account + ".txt");
            myReader = new Scanner(accountDetailsFile);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (account.equalsIgnoreCase("SavingsAccount")) {
                    SavingsAccount savingsAccount = mapper.readValue(data, SavingsAccount.class);
                    savingsAccounts.add(savingsAccount);
                } else if (account.equalsIgnoreCase("CheckingAccount")) {
                    CheckingAccount checkingAccount = mapper.readValue(data, CheckingAccount.class);
                    checkingAccounts.add(checkingAccount);
                }
            }
            myReader.close();

            if (savingsAccounts.size() > 0) {
                System.out.println("Savings account balance of client " + clientName + " is " + savingsAccounts.stream().filter(singleAccount -> {
                    return singleAccount.getAccountName().contains(clientName);
                }).collect(Collectors.toList()).get(0).getSavingsBalance());

            } else if (checkingAccounts.size() > 0) {
                System.out.println("Checking account balance of client " + clientName + " is " + checkingAccounts.stream().filter(singleAccount -> {
                    return singleAccount.getAccountName().contains(clientName);
                }).collect(Collectors.toList()).get(0).getCheckingBalance());
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        operationMenu();
    }

    public static void depositMoney() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
        System.out.println("Please enter the client name to deposit money");
        Scanner scan = new Scanner(System.in);
        String clientName = scan.next();
        System.out.println("Please select the type of account to deposit money");
        System.out.println("Press 1 to select Savings Account");
        System.out.println("Press 2 to select Checking Account");


        int accountType = scan.nextInt();
        String account = null;
        if (accountType == 1) {
            account = "SavingsAccount";
        } else if (accountType == 2) {
            account = "CheckingAccount";
        }

        System.out.println("Please enter the amount to deposit");
        double depositAmount = scan.nextDouble();
        File accountDetailsFile = new File
                (System.getProperty("user.home") + "/Desktop/MAD3463/" + account + ".txt");

        Scanner myReader = new Scanner(accountDetailsFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            if (account.equalsIgnoreCase("SavingsAccount")) {
                SavingsAccount savingsAccount = mapper.readValue(data, SavingsAccount.class);
                savingsAccounts.add(savingsAccount);
            } else {
                CheckingAccount checkingAccount = mapper.readValue(data, CheckingAccount.class);
                checkingAccounts.add(checkingAccount);
            }
        }

        if (account.equalsIgnoreCase("SavingsAccount")) {

            savingsAccounts.forEach(singleAccount->{
                if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                    singleAccount.setSavingsBalance(singleAccount.getSavingsBalance() + depositAmount);
                    System.out.println(singleAccount.getSavingsBalance());
                }
            });
        } else {
            checkingAccounts.forEach((singleAccount) -> {
                if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                    singleAccount.setCheckingBalance(singleAccount.getCheckingBalance() + depositAmount);
                }
            });
        }
        FileOutputStream fOut = new FileOutputStream(accountDetailsFile);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        if (account.equalsIgnoreCase("SavingsAccount")) {
            savingsAccounts.forEach((singleAccount) -> {
                try {
                    osw.write(mapper.writeValueAsString(singleAccount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            checkingAccounts.forEach((singleAccount) -> {
                try {
                    osw.write(mapper.writeValueAsString(singleAccount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        osw.flush();
        osw.close();
        operationMenu();
    }

    public static void drawMoney() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
        System.out.println("Please enter the client name to deposit money");
        Scanner scan = new Scanner(System.in);
        String clientName = scan.next();
        System.out.println("Please select the type of account to deposit money");
        System.out.println("Press 1 to select Savings Account");
        System.out.println("Press 2 to select Checking Account");


        int accountType = scan.nextInt();
        String account = null;
        if (accountType == 1) {
            account = "SavingsAccount";
        } else if (accountType == 2) {
            account = "CheckingAccount";
        }

        System.out.println("Please enter the amount to draw");
        double drawAmount = scan.nextDouble();
        File accountDetailsFile = new File
                (System.getProperty("user.home") + "/Desktop/MAD3463/" + account + ".txt");

        Scanner myReader = new Scanner(accountDetailsFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            if (account.equalsIgnoreCase("SavingsAccount")) {
                SavingsAccount savingsAccount = mapper.readValue(data, SavingsAccount.class);
                savingsAccounts.add(savingsAccount);
            } else if (account.equalsIgnoreCase("CheckingAccount")) {
                CheckingAccount checkingAccount = mapper.readValue(data, CheckingAccount.class);
                checkingAccounts.add(checkingAccount);
            }
        }

        if (account.equalsIgnoreCase("SavingsAccount")) {
            savingsAccounts.forEach((singleAccount) -> {
                if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                    if (singleAccount.getSavingsBalance() > drawAmount) {
                        singleAccount.setSavingsBalance(singleAccount.getSavingsBalance() - drawAmount);
                        System.out.println(singleAccount.getSavingsBalance());
                    }
                }
            });
        } else if (account.equalsIgnoreCase("CheckingAccount")) {
            checkingAccounts.forEach((singleAccount) -> {
                if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {

                    if (singleAccount.getCheckingBalance() > drawAmount) {
                        singleAccount.setCheckingBalance(singleAccount.getCheckingBalance() - drawAmount);
                    }
                }
            });
        }
        FileOutputStream fOut = new FileOutputStream(accountDetailsFile);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        if (account.equalsIgnoreCase("SavingsAccount")) {
            savingsAccounts.forEach((singleAccount) -> {
                try {
                    osw.write(mapper.writeValueAsString(singleAccount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            checkingAccounts.forEach((singleAccount) -> {
                try {
                    osw.write(mapper.writeValueAsString(singleAccount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        osw.flush();
        osw.close();
        operationMenu();
    }

    public static void transferMoney() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the client account name");


        String clientName = scan.next();
        System.out.println("Please select the account to transfer the amount from");
        System.out.println("Please enter 1 for savings account");
        System.out.println("Please enter 2 for checking account");
        int fromAccountType = scan.nextInt();

        System.out.println("Please enter the amount to transfer");
        double transferAmount = scan.nextDouble();
        String fromAccountTypeString = null;

        if (fromAccountType == 1) {
            fromAccountTypeString = "SavingsAccount";
        } else if (fromAccountType == 2) {
            fromAccountTypeString = "CheckingAccount";
        }
        File accountDetailsFile = new File
                (System.getProperty("user.home") + "/Desktop/MAD3463/"+ fromAccountTypeString+".txt");

        Scanner myReader = new Scanner(accountDetailsFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);

            if (fromAccountTypeString.equalsIgnoreCase("SavingsAccount")) {
                SavingsAccount savingsAccount = mapper.readValue(data, SavingsAccount.class);
                savingsAccounts.add(savingsAccount);
            } else if (fromAccountTypeString.equalsIgnoreCase("CheckingAccount")) {
                CheckingAccount checkingAccount = mapper.readValue(data, CheckingAccount.class);
                checkingAccounts.add(checkingAccount);
            }
        }



            if (fromAccountTypeString.equalsIgnoreCase("SavingsAccount")) {
                savingsAccounts.forEach((singleAccount) -> {
                    if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                        if (singleAccount.getSavingsBalance() >= transferAmount) {
                            singleAccount.setSavingsBalance(singleAccount.getSavingsBalance() - transferAmount);
                        }
                    }
                });
            } else {
                checkingAccounts.forEach((singleAccount) -> {
                    if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                        if (singleAccount.getCheckingBalance() >= transferAmount) {
                            singleAccount.setCheckingBalance(singleAccount.getCheckingBalance() - transferAmount);
                        }
                    }
                });
            }

        FileOutputStream fOut = new FileOutputStream(accountDetailsFile);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
            if(fromAccountTypeString.equalsIgnoreCase("SavingsAccount")){
                savingsAccounts.forEach((singleAccount) -> {
                    try {
                        osw.write(mapper.writeValueAsString(singleAccount));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }else{
                checkingAccounts.forEach((singleAccount) -> {
                    try {
                        osw.write(mapper.writeValueAsString(singleAccount));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            System.out.println("Please select the account to transfer the amount to");
            System.out.println("Please enter 1 for savings account");
            System.out.println("Please enter 2 for checking account");

            int toChoice = scan.nextInt();

            String toAccountTypeString = null;

            if (toChoice == 1) {
                toAccountTypeString = "SavingsAccount";
            } else if (toChoice == 2) {
                toAccountTypeString = "CheckingAccount";
            }

            ArrayList<SavingsAccount> tosavingsAccounts = new ArrayList<>();
            ArrayList<CheckingAccount> tocheckingAccounts = new ArrayList<>();

            File toAccountDetailsFile = new File
                    (System.getProperty("user.home") + "/Desktop/MAD3463/" + toAccountTypeString + ".txt");

            Scanner toMyReader = new Scanner(toAccountDetailsFile);
            while (toMyReader.hasNextLine()) {
                String data1 = toMyReader.nextLine();
                System.out.println(data1);

                if (toAccountTypeString.equalsIgnoreCase("SavingsAccount")) {
                    SavingsAccount savingsAccount = mapper.readValue(data1, SavingsAccount.class);
                    tosavingsAccounts.add(savingsAccount);
                } else if (toAccountTypeString.equalsIgnoreCase("CheckingAccount")) {
                    CheckingAccount checkingAccount = mapper.readValue(data1, CheckingAccount.class);
                    tocheckingAccounts.add(checkingAccount);
                }
            }
                FileOutputStream tofOut = new FileOutputStream(toAccountDetailsFile);
                OutputStreamWriter toosw = new OutputStreamWriter(tofOut);

                if (toAccountTypeString.equalsIgnoreCase("SavingsAccount")) {
                    tosavingsAccounts.forEach((singleAccount) -> {

                        if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                            singleAccount.setSavingsBalance(singleAccount.getSavingsBalance() + transferAmount);
                        }
                        try {
                            toosw.write(mapper.writeValueAsString(singleAccount));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    tocheckingAccounts.forEach((singleAccount) -> {
                        if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                            singleAccount.setCheckingBalance(singleAccount.getCheckingBalance() + transferAmount);
                        }
                        try {
                            toosw.write(mapper.writeValueAsString(singleAccount));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
        operationMenu();
    }

    public static void payUtilityBills() throws
            IOException {

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
        System.out.println("Please enter the client name to pay utility bills");
        Scanner scan = new Scanner(System.in);
        String clientName = scan.next();

        System.out.println("Please enter the utility bill amount");
        double utilityBill = scan.nextDouble();
        System.out.println("Please select the account to pay utility bills");
        System.out.println("Please enter 1 for savings account");
        System.out.println("Please enter 2 for checking account");
        int choice = scan.nextInt();
        String accountType = null;

        if (choice == 1) {
            accountType = "SavingsAccount";
        } else {
            accountType = "CheckingAccount";
        }

        File accountDetailsFile = new File
                (System.getProperty("user.home") + "/Desktop/MAD3463/" + accountType + ".txt");

        Scanner myReader = new Scanner(accountDetailsFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);

            if (accountType.equalsIgnoreCase("SavingsAccount")) {
                SavingsAccount savingsAccount = mapper.readValue(data, SavingsAccount.class);
                savingsAccounts.add(savingsAccount);
            } else if (accountType.equalsIgnoreCase("CheckingAccount")) {
                CheckingAccount checkingAccount = mapper.readValue(data, CheckingAccount.class);
                checkingAccounts.add(checkingAccount);
            }

            if(accountType.equalsIgnoreCase("SavingsAccount")) {
                savingsAccounts.forEach((singleAccount) -> {

                    if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                        if(singleAccount.getSavingsBalance()> utilityBill){
                            singleAccount.setSavingsBalance
                                    (singleAccount.getSavingsBalance() - utilityBill);
                        }
                    }else{

                    }
                });
            }else{
                checkingAccounts.forEach((singleAccount) -> {

                    if (singleAccount.getAccountName().equalsIgnoreCase(clientName)) {
                        if(singleAccount.getCheckingBalance()> utilityBill){
                            singleAccount.setCheckingBalance
                                    (singleAccount.getCheckingBalance() - utilityBill);
                        }
                    }else{

                    }
                });
            }
        }
        FileOutputStream fOut = new FileOutputStream(accountDetailsFile);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        if (accountType.equalsIgnoreCase("SavingsAccount")) {
            savingsAccounts.forEach((singleAccount) -> {
                try {
                    osw.write(mapper.writeValueAsString(singleAccount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            checkingAccounts.forEach((singleAccount) -> {
                try {
                    osw.write(mapper.writeValueAsString(singleAccount));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        osw.flush();
        osw.close();
        operationMenu();
    }
}
