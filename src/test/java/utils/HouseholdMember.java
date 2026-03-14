package utils;

public class HouseholdMember {

    public String relationship;
    public String firstName;
    public String lastName;
    public String dob;
    public String gender;
    public String hispanic;
    public String race;
    public String otherStay;

    public HouseholdMember(String relationship,
                           String firstName,
                           String lastName,
                           String dob,
                           String gender,
                           String hispanic,
                           String race,
                           String otherStay) {

        this.relationship = relationship;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.hispanic = hispanic;
        this.race = race;
        this.otherStay = otherStay;
    }
}
