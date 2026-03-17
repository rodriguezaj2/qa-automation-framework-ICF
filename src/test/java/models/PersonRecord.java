package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PersonRecord {

    private Integer id;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String telephone;
    private Integer householdId;
    private String hispanic;
    private String hispanicOther;
    private String race;
    private String raceOther;
    private String otherStay;

    public PersonRecord() {
    }

    public PersonRecord(Integer id, String firstName, String lastName, String dob,
                        String gender, String telephone, Integer householdId,
                        String hispanic, String hispanicOther, String race,
                        String raceOther, String otherStay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.telephone = telephone;
        this.householdId = householdId;
        this.hispanic = hispanic;
        this.hispanicOther = hispanicOther;
        this.race = race;
        this.raceOther = raceOther;
        this.otherStay = otherStay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public String getHispanic() {
        return hispanic;
    }

    public void setHispanic(String hispanic) {
        this.hispanic = hispanic;
    }

    public String getHispanicOther() {
        return hispanicOther;
    }

    public void setHispanicOther(String hispanicOther) {
        this.hispanicOther = hispanicOther;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRaceOther() {
        return raceOther;
    }

    public void setRaceOther(String raceOther) {
        this.raceOther = raceOther;
    }

    public String getOtherStay() {
        return otherStay;
    }

    public void setOtherStay(String otherStay) {
        this.otherStay = otherStay;
    }
}
