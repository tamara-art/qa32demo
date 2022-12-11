package demo.data;

public class Student {
    public String getPictureLink() {
        return pictureLink;
    }

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    };

    String firstName;
    String lastName;
    String email;

    String dateOfBirth;

    String pictureLink;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    //    String gender;
    Gender gender;

    String phone;

    public Student(String firstName, String lastName, String email,
                   Gender gender, String phone, String dateOfBirth, String pictureLink){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.pictureLink = pictureLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }
}
