import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Example {
    public static void main(String[] args) {
        Student s1=new Student(1,"Lokesh");
        Student s2=new Student(1,"Lokesh");
        HashMap<Student,Integer> hm=new HashMap<>();
        hm.put(s1,1);
        hm.put(s2,2);
        for(Map.Entry<Student,Integer> e:hm.entrySet()){
            System.out.println(e.getKey()+" -> "+e.getValue());
        }
    }

}
class Student{
    private int rno;

    public Student(int rno, String name) {
        this.rno = rno;
        this.name = name;
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getRno() == student.getRno() &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRno(), getName());
    }
}
