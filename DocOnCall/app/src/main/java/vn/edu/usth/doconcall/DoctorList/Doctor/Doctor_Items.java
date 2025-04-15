package vn.edu.usth.doconcall.DoctorList.Doctor;

public class Doctor_Items {

    String name;
    String specialization;
    String rating;

    public Doctor_Items(String name, String specialization, String rating){
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
