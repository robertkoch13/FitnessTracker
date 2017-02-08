package za.co.entelect.jbootcamp.enums;

public enum Gender {
    Male("Male"), Female("Female");

    String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

}
