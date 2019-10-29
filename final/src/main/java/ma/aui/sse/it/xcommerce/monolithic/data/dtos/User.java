package ma.aui.sse.it.xcommerce.monolithic.data.dtos;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = -2789798823602463949L;
    private String username;
    private String password;
    private String passwordConfirmation;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String emailAddressConfirmation;
    private String address;


    protected User() { }

    public User(String username, String firstName, String lastName,
                String emailAddress, String address){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getEmailAddressConfirmation() {
        return emailAddressConfirmation;
    }

    public void setEmailAddressConfirmation(String emailAddressConfirmation) {
        this.emailAddressConfirmation = emailAddressConfirmation;
    }
}