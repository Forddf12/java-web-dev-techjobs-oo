package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    //Initialize unique ID
    public Job() {
        id = nextId;
        nextId++;
    }
    //Initialize the other 5 fields

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String someJob = "";
        //Check to see if all fields are empty
        if (name == " " | name == "" &&
                employer.getValue().equals(" ") | employer.getValue().equals("") &&
                location.getValue().equals(" ") | location.getValue().equals("") &&
                positionType.getValue().equals(" ") | positionType.getValue().equals("") &&
                coreCompetency.getValue().equals(" ") | coreCompetency.getValue().equals("")) {
            return "\n" + "This job does not seem to exist!" + "\n";
        }

        //Check to see if any fields are empty
        if (name == " " | name == "") {
            name = "Data not available!";
        }
        if (employer.getValue() == " " | employer.getValue() == "") {
            employer.setValue("Data not available!"); }
        if (location.getValue() == " " | location.getValue() == "") {
            location.setValue("Data not available!");}
        if (positionType.getValue() == " " | positionType.getValue() == "") {
            positionType.setValue("Data not available!");}
        if (coreCompetency.getValue() == " " | coreCompetency.getValue() == "") {
            coreCompetency.setValue("Data not available!");}
        //set up format for output
        someJob = String.format("\n" + "ID: " + this.getId() + "\n" +
                "Name: " +this.getName() + "\n" +
                "Employer: " + this.getEmployer() + "\n" +
                "Location: " + this.getLocation() + "\n" +
                "Position Type: " + this.getPositionType() + "\n" +
                "Core Competency: " + this.getCoreCompetency() + "\n");
        return someJob;
    }
}
