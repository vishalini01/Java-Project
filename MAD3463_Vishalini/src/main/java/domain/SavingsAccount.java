package domain;

public class SavingsAccount {

    private String accountName;
    private long accountNumber;
    private String address;
    private double savingsInterestRate;
    private double savingsBalance;

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

    public double getSavingsInterestRate() {
        return savingsInterestRate;
    }

    public void setSavingsInterestRate(double savingsInterestRate) {
        this.savingsInterestRate = savingsInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber=" + accountNumber +
                ", address='" + address + '\'' +
                ", savingsInterestRate=" + savingsInterestRate +
                ", savingsBalance=" + savingsBalance +
                '}';
    }
}
