package domain;

public class ClientDetails {

    private String clientName;
    private String address;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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
                "clientName='" + clientName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
