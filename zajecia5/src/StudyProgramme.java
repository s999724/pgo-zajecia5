public class StudyProgramme {
    private String programmeName;
    private String programmeDescription;
    private int numberOfSemesters;
    private int numberOfReqITNs;

    public StudyProgramme(String programmeName, String programmeDescription, int numberOfSemesters, int numberOfReqITNs) {
        this.programmeName = programmeName;
        this.programmeDescription = programmeDescription;
        this.numberOfSemesters = numberOfSemesters;
        this.numberOfReqITNs = numberOfReqITNs;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public String getProgrammeDescription() {
        return programmeDescription;
    }

    public int getNumberOfSemesters() {
        return numberOfSemesters;
    }

    public int getNumberOfReqITNs() {
        return numberOfReqITNs;
    }
}
