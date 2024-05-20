import java.util.ArrayList;

public abstract class Students {
    private static ArrayList<Student> studentList = new ArrayList<>();
    public static void addStudent(Student s){
        studentList.add(s);
    }
    public static void promoteAllStudents() {
        for (Student student : studentList){
            student.promoteToNextSemester();
        }
    }
    public static void displayInfoAboutAllStudents() {
        System.out.println("The current semester for all students is:");
        for (Student student : studentList){
            StudentStatus tempStatus = student.getPersonalStatus();
            if (tempStatus == StudentStatus.Student){
                StudyProgramme tempProgramme = student.getCurrProgramme();
                System.out.println(student.getFirstName() + " " + student.getLastName() + " is on semester "
                        + student.getCurrSemester() + " out of " + tempProgramme.getNumberOfSemesters());
            } else {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " is a " + tempStatus);
            }
        }
        System.out.println("Finished the list of students");
    }
}
