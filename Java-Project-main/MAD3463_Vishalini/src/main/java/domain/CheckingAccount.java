package domain;

public class CheckingAccount {

    private String Acc_Name;
    private long Acc_Number;
    private String Address;
    private double Check_Balance;

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

    public double getCheckingBalance() {
        return Check_Balance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.Check_Balance = checkingBalance;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountName='" + Acc_Name + '\'' +
                ", accountNumber=" + Acc_Number +
                ", address='" + Address + '\'' +
                ", checkingBalance=" + Check_Balance +
                '}';
    }
}
