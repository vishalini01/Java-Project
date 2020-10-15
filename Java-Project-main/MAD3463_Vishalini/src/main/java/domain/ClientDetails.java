package domain;

public class ClientDetails {

    private String Client_Name;
    private String address;

    public String getClientName() {
        return Client_Name;
    }

    public void setClientName(String clientName) {
        this.Client_Name = clientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ClientDetails{" +
                "clientName='" + Client_Name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
