import java.util.*;

public class main {

    private HashMap <Integer,course> courseMap = new HashMap<Integer,course>();
    private HashMap <Integer,student> studentMap = new HashMap<Integer,student>();

    public course registerCourse (int code , String name , String coordinator){
        if (code != 0 && name != "" && coordinator != "") {
            course courseAux = new course(code,name,coordinator);
            courseMap.put(code,courseAux);
            return courseAux;
        }
        else{
            throw new RuntimeException("the course parameters cannot be blank ");
        }
    }

    public student registerStudent (int id , String name, String email){
        if (id != 0 && name != "" && email != "") {
            student studentAux = new student(id, name, email);
            studentMap.put(id,studentAux);
            return studentAux;
        }
        else{
             throw new RuntimeException("the student parameters cannot be blank ");
        }
    }

    public void enrolledStudent (int id , int code){
        if (courseMap.containsKey(code) && studentMap.containsKey(id)){
            ArrayList <student> auxMap = courseMap.get(code).getStudentsArray();
            if(auxMap.size()<=50 ){
                student studentAux = studentMap.get(id);
                if (!auxMap.contains(studentAux)) {
                    auxMap.add(studentAux);
                    courseMap.get(code).setStudentsArray(auxMap);
                }
                else{
                    throw new RuntimeException("the student its already enrolled ");
                }
            }
            else{
                throw new RuntimeException("the course its already on the students limit");
            }
        }
        else{
            throw new RuntimeException("the course or the student its not registered");
        }
    }

    public ArrayList<student> getStudentsList (int code){
        ArrayList <student> listAux = new ArrayList<student>();
        if(courseMap.containsKey(code)){
            listAux = courseMap.get(code).getStudentsArray();
        }else{
            throw new RuntimeException("the course its not registered ");
        }
        return listAux;
    }

    public void cancelEnrollment (int id, int code){
        if (courseMap.containsKey(code) && studentMap.containsKey(id)
                &&!courseMap.get(code).getStudentsArray().contains(studentMap.get(id))) {
            ArrayList <student> auxMap = courseMap.get(code).getStudentsArray();
            auxMap.remove(studentMap.get(id));
            courseMap.get(code).setStudentsArray(auxMap);
        }
        else{
            throw new RuntimeException("the course or the course its not registered , or the student its note enrolled on the course ");
        }
    }

    public void restartCourse(int code){
        if (courseMap.containsKey(code) ) {
             ArrayList <student> restartArray = new ArrayList<student>() ;
             courseMap.get(code).setStudentsArray(restartArray);
        }else{
            throw new RuntimeException("the course its not registerd");
        }
    }

    public ArrayList<student> getStudents (){
        HashMap<Integer,student> AuxMap = this.studentMap;
        ArrayList<student> auxiliar = shortHashMap(AuxMap);
        return auxiliar;
    }

    public ArrayList<course> getCourse (){
        HashMap<Integer,course> AuxMap = this.courseMap;
        ArrayList<course> auxiliar = shortHashMap(AuxMap);
        return auxiliar;
    }


    private <T> ArrayList <T> shortHashMap (HashMap<Integer,T> aux){
        ArrayList<T> auxiliar = new ArrayList<T>();
        Iterator <Integer> it = aux.keySet().iterator();
        TreeMap<Integer,T> tm=new  TreeMap<Integer,T> (aux);
        while(it.hasNext())
        {
            int key=(int)it.next();

            auxiliar.add(aux.get(key));
        }
    return auxiliar;
    }

    private  ArrayList <student> shortArrayList(ArrayList<student> aux ){
        ArrayList<student> auxiliar = new ArrayList<student>();
        int [] auxiliarStudentArray = new int[aux.size()];

        for (int i = 0; i< aux.size();i++){
            auxiliarStudentArray[i] = aux.get(i).getId();
        }
        int temp;
        for (int i = 1; i < auxiliarStudentArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (auxiliarStudentArray[j] < auxiliarStudentArray [j - 1]) {
                    temp = auxiliarStudentArray[j];
                    auxiliarStudentArray[j] = auxiliarStudentArray[j - 1];
                    auxiliarStudentArray[j - 1] = temp;
                }
            }
        }
        for(int i = 0;i < auxiliarStudentArray.length;i++){
            auxiliar.add(studentMap.get(auxiliarStudentArray[i]));
        }

        return auxiliar;

    }


    public static void main(String[] args) {

    }
}

