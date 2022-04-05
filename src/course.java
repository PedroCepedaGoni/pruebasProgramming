import java.util.ArrayList;
import java.util.HashMap;
public class course {

    private int code;
    private String name;
    private String coordinator;
    private ArrayList <student> studentsMap;

    public course(int code, String name, String coordinator) {
        this.code = code;
        this.name = name;
        this.coordinator = coordinator;
        this.studentsMap = new ArrayList <student>();
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public ArrayList< student> getStudentsArray() {
        return studentsMap;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public void setStudentsArray(ArrayList< student> studentsMap) {
        this.studentsMap = studentsMap;
    }
}
