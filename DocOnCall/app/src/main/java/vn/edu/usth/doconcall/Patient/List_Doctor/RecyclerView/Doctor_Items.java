package vn.edu.usth.doconcall.Patient.List_Doctor.RecyclerView;

public class Doctor_Items {String name;
    String specialization;
    String rating;

    int doctor_image;

    public Doctor_Items(String name, String specialization, String rating, int doctor_image){
        this.name = name;
        this.specialization = specialization;
        this.rating = rating;
        this.doctor_image = doctor_image;
    }

    public String getName(){return name;}

    public String getRating() {
        return rating;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getDoctor_image(){return doctor_image;}

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setDoctor_image(int doctor_image) {
        this.doctor_image = doctor_image;
    }
}
