package domain;

public class SavingsAccount {

    private String Acc_Name;
    private long Acc_Number;
    private String Address;
    private double SavingsInterestRate;
    private double SavingsBalance;

    public String getAccountName() {
        return Acc_Name;
    }

    public void setAccountName(String accountName) {
        this.Acc_Name = accountName;
    }

    public long getAccountNumber() {
        return Acc_Number;
    }

    public void setAccountNumber(long accountNumber) {
        this.Acc_Number = accountNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public double getSavingsInterestRate() {
        return SavingsInterestRate;
    }

    public void setSavingsInterestRate(double savingsInterestRate) {
        this.SavingsInterestRate = savingsInterestRate;
    }

    public double getSavingsBalance() {
        return SavingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.SavingsBalance = savingsBalance;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountName='" + Acc_Name + '\'' +
                ", accountNumber=" + Acc_Number +
                ", address='" + Address + '\'' +
                ", savingsInterestRate=" + SavingsInterestRate +
                ", savingsBalance=" + SavingsBalance +
                '}';
    }
}
