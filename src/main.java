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
            List <student> auxMap = courseMap.get(code).getStudentsArray();
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

    public List<student> getStudentsList (int code){
        List <student> listAux = new ArrayList<student>();
        if(courseMap.containsKey(code)){
            listAux = sortList(courseMap.get(code).getStudentsArray());

        }else{
            throw new RuntimeException("the course its not registered ");
        }
        return listAux;
    }

    public void cancelEnrollment (int id, int code){
        if (courseMap.containsKey(code) && studentMap.containsKey(id)
                &&!courseMap.get(code).getStudentsArray().contains(studentMap.get(id))) {
            List <student> auxMap = courseMap.get(code).getStudentsArray();
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

    public List<student> getStudents (){
        HashMap<Integer,student> AuxMap = this.studentMap;
        List <student> auxiliar = shortHashMap(AuxMap);
        return auxiliar;
    }

    public List<course> getCourse (){
        HashMap<Integer,course> AuxMap = this.courseMap;
        List<course> auxiliar = shortHashMap(AuxMap);
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


    private  static List <student> sortList(List<student> aux ) {
        List <student> listAuxParam = aux;
        student temp ;
        for (int i = 1; i < listAuxParam.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (listAuxParam.get(j).getId() < listAuxParam.get(j-1).getId()) {
                    temp = listAuxParam.get(j);
                    listAuxParam.set(j,listAuxParam.get(j-1));
                    listAuxParam.set(j-1,temp);
                }
            }
        }
        return listAuxParam;
    }


    public static void main(String[] args) {
        List <student> auxiliar = new ArrayList<student>();
        List <student> auxiliarResultado;
        student temp = new student(0,"","");
        student temp2 = new student(2,"","");
        student temp3 = new student(5,"","");
        student temp4 = new student(1,"","");
        auxiliar.add(temp);
        auxiliar.add(temp2);
        auxiliar.add(temp3);
        auxiliar.add(temp4);

        auxiliarResultado = sortList(auxiliar);


        for (student student : auxiliarResultado) {
            System.out.print(student.getId());
        }

    }
}

