package QuanLySinhVien;

import java.util.Comparator;

public class sortStudentById implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getId() < o2.getId()) {
            return -1;
        }
        else return 1;
    }
}
