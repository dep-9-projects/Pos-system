package util;

public class Customers {
    private String contactNumber;

    private String name;

    private String address;

    public Customers() {
    }

    public Customers(String contactNumber, String name, String address) {
        this.contactNumber = contactNumber;
        this.name = name;
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
