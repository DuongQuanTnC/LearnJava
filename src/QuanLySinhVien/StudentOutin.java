package QuanLySinhVien;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentOutin {
    public void genFile(List<Student> studentList, String file) {
        try {
            File f = new File(file);
            FileWriter fw = new FileWriter(file);

            for(Student s : studentList) {
                fw.append(s.getId().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
