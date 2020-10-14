package domain;

public class CheckingAccount {

    private String accountName;
    private long accountNumber;
    private String address;
    private double checkingBalance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber=" + accountNumber +
                ", address='" + address + '\'' +
                ", checkingBalance=" + checkingBalance +
                '}';
    }
}
