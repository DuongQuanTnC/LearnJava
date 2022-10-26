package QuanLySinhVien;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentOutin {
    private List<Student> studentList = new ArrayList<>();
    public void genFile(List<Student> studentList, String file) {
        try {
            File f = new File(file);
            FileWriter fw = new FileWriter(file);
            for(Student s : studentList) {
                fw.append(String.valueOf(s.getId())).append("@@")
                        .append(s.getName()).append("@@")
                        .append(String.valueOf(s.getAge())).append("@@")
                        .append(s.getAddress()).append("@@")
                        .append(String.valueOf(s.getGpa()))
                        .append("\n");
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public List<Student> read() {
        String file = "src/QuanLySinhVien/Student.txt";
            try {
                Path path = Path.of(file);
                List<String> listStudent = Files.readAllLines(path);
                if(listStudent != null) {
                    for (String data : listStudent) {
                        String[] dataList = data.split("@@");
                        Student s = new Student();

                        s.setId(Integer.parseInt(dataList[0]));
                        s.setName(dataList[1]);
                        s.setAge(Integer.parseInt(dataList[2]));
                        s.setAddress(dataList[3]);
                        s.setGpa(Float.parseFloat(dataList[4]));

                        studentList.add(s);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return studentList;
        }
}


