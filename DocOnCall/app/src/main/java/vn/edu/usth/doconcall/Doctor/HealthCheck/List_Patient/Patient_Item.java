package vn.edu.usth.doconcall.Doctor.HealthCheck.List_Patient;

public class Patient_Item {

    String name;
    String gender;
    String phone_number;
    String dob;

    public Patient_Item(String name, String gender, String phone_number, String dob){
        this.name = name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }
}
