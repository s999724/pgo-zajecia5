import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Student extends Students {
    private static int studentsCounter = 0;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String eMail;
    private String homeAddress;
    private String phoneNumber;
    private String studentIndex;
    private StudentStatus personalStatus;
    private int currSemester = 0;
    private StudyProgramme currProgramme;
    private ArrayList<Grade> gradesList = new ArrayList<>();
    public Student(String firstName, String lastName, String eMail,
                   String homeAddress, String phoneNumber, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        studentsCounter++;
        this.studentIndex = "s" + studentsCounter;
        personalStatus = StudentStatus.Candidate;
        Students.addStudent(this);
    }
    public void enrollStudent(StudyProgramme sp) {
        if (personalStatus != StudentStatus.Candidate){
            System.out.println("Student is already enrolled in a programme");
            return;
        }
        currProgramme = sp;
        personalStatus = StudentStatus.Student;
        currSemester++;
        System.out.println("Successfully enrolled student in " + sp.getProgrammeName());
    }
    public void promoteToNextSemester(){
        if (personalStatus != StudentStatus.Student){return;}
        int numberOfITNs = currProgramme.getNumberOfReqITNs();
        int actualNumberOfITNs = gradesList.size();
        if (actualNumberOfITNs > numberOfITNs){
            System.out.println("Student exceeded max number of ITNs per semester, and therefore cannot be promoted");
            return;
        }
        if (currSemester != currProgramme.getNumberOfSemesters()){
            currSemester++;
        } else {
            personalStatus = StudentStatus.Graduate;
        }
        gradesList.clear();
    }
    public void addGrade(int grade, String subject) {
        if (personalStatus != StudentStatus.Student){return;}
        if (!(grade >= 2 && grade <= 5)){
            System.out.println("Grade " + grade + " is out of bounds. The grade should be a number between 2 and 5");
            return;
        }
        for (Grade pair : gradesList) {
            if (Objects.equals(subject, pair.getSubject())) {
                System.out.println("Student already graded for the subject " + subject);
                return;
            }
        }
        gradesList.add(new Grade(grade, subject));
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        Date tempDate = new Date(birthDate.getYear(), birthDate.getMonth(), birthDate.getDay());
        return tempDate;
    }

    public String geteMail() {
        return eMail;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStudentIndex() {
        return studentIndex;
    }

    public StudentStatus getPersonalStatus() {
        return personalStatus;
    }

    public int getCurrSemester() {
        return currSemester;
    }

    public StudyProgramme getCurrProgramme() {
        StudyProgramme tempProgramme = new StudyProgramme(currProgramme.getProgrammeName(), currProgramme.getProgrammeDescription(),
                currProgramme.getNumberOfSemesters(), currProgramme.getNumberOfReqITNs());
        return tempProgramme;
    }

    public ArrayList<Grade> getGradesList(){
        ArrayList<Grade> tempList = new ArrayList<>();
        tempList.addAll(gradesList);
        return tempList;
    }
}
