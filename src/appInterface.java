import java.util.ArrayList;

public interface appInterface {

    course registerCourse (int code , String name , String coordinator); // this method register a new course into the system

    student registerStudent (int id , String name, String email);        // this method register a new student into the system

    void enrolledStudent (int id , int code);                            //this method add a new student into a course

    ArrayList<student> getStudentsList (int code);                       //this method returns an ArrayList containing all the students in a course

    void cancelEnrollment (int id, int code);                            //this method removes a student of the course

    void restartCourse(int code);                                        //this method restart the students list of a course

    ArrayList<student> getStudents ();                                   //this method returns an ArrayList of all the students on the system

    ArrayList<course> getCourse ();                                      //this method returns an ArrayList of All the courses on the system

}
