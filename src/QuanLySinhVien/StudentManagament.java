package QuanLySinhVien;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManagament {

    private List<Student> studentList;
    private StudentOutin studentOutin;

    private String fileName = "src/QuanLySinhVien/Student.txt";
    Scanner scanner = new Scanner(System.in);


    public StudentManagament() {
        this.studentOutin = new StudentOutin();
        this.studentList = studentOutin.read();
    }

    public void add() {
        int size = studentList.size();
        int id = (size > 0 ? size + 1 : 1);
        System.out.println("ID : " + id);
        String name = inputName();
        int age = inputAge();
        String address = inputAddress();
        float gpa = inputGpa();

        Student student = new Student(id, name, age, address, gpa);
        studentList.add(student);
        studentOutin.genFile(studentList, fileName);
        System.out.println("Them moi thanh cong!");
    }

    public void show() {
        System.out.format("%12s %22s %9s %22s %8s%n"
                ,"ID |"
                ,"Name |"
                ,"Age |"
                ,"Address |"
                ,"GPA" );
        System.out.println("-------------------------------------------------------------------------------");
        for (Student student : studentList) {
            System.out.format("%10s | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%7s | ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%8.1f%n", student.getGpa());
        }
    }

    public void delete(int id) {
        Student student = null;

        for(int i = 0 ; i < studentList.size() ; i++)
        {
            if(studentList.get(i).getId() == id) {
                student = studentList.get(i);
                break;
            }
        }
        if(student != null) {
            studentList.remove(student);
            studentOutin.genFile(studentList, fileName);
            System.out.println("Xoá thành công!\n");
            sortID();
        }
        else {
            System.out.println("ID " + id + " Khong ton tai!");
        }
    }

    public int inputAge() {
        System.out.print("Enter age: ");
        while(true) {
            try {
                int age = scanner.nextInt();
                scanner.nextLine();
                if(age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.print("Invalid! Enter age again: ");;
            }
        }
    }

    public int inputId() {
        System.out.print("Enter ID: ");
        while(true) {
            try {
                int id = scanner.nextInt();
                scanner.nextLine();
                return id;
            } catch (NumberFormatException e) {
                System.out.print("Invalid! Enter ID again: ");;
            }
        }
    }

    public String inputName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String inputAddress() {
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        return address;
    }

    public float inputGpa() {
        System.out.print("Enter GPA: ");
        while(true) {
            try {
                float gpa = scanner.nextFloat();
                if(gpa < 0 && gpa > 10.0) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException e) {
                System.out.print("Invalid! Enter GPA again: ");;
            }
        }
    }

    public void edit(int id) {
        boolean isExisted = false;
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getId() == id) {
                isExisted = true;
                studentList.get(i).setId(id);
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentOutin.genFile(studentList, fileName);
            System.out.println("Sua sinh vien thanh cong \n");
        }
    }

    public void sortStudentByName() {
        Collections.sort(studentList,new SortStudentByName());
    }

    public void sortStudentByGpa() {
        Collections.sort(studentList, new SortStudentByGpa());
    }

    public void sortStudentbyId() {
        Collections.sort(studentList, new sortStudentById());
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void sortID() {
        int size = studentList.size();
        for(int i = 0 ; i < size ; i++) {
            studentList.get(i).setId(i + 1);
            studentOutin.genFile(studentList, fileName);
        }
    }
}
