package QuanLySinhVien;

import java.util.List;
import java.util.Scanner;

public class StudentManagament {

    private List<Student> studentList;
    private StudentOutin studentOutin;
    Scanner scanner = new Scanner(System.in);


    public StudentManagament() {
        studentOutin = new StudentOutin();
        studentList = studentOutin.read();
    }

    public void add() {

        int size = studentList.size();
        int id = (size > 0 ? size + 1 : 1);

        System.out.println("ID : " + id);
        String name = inputName();
        int age = inputAge();
        scanner.nextLine();
        String address = address();
        float gpa = inputGPA();

        Student student = new Student(id, name, age, address, gpa);

        studentList.add(student);

        studentOutin.write(studentList);
    }

    public void show() {
        for (Student student : studentList) {
            System.out.format("%10s | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%10s| ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%10.1f%n", student.getGpa());
        }
    }

    public void delete(int id) {
        Student student = null;
        if(studentList.contains(id))
        {
            int i = studentList.indexOf(id);
            student = studentList.get(i);
            studentList.remove(student);
            studentOutin.write(studentList);
        }
        else
        {
            System.out.println("ID: " + id + " Khong ton tai!");
        }
    }

    public int inputAge() {
        System.out.print("Enter age: ");
        while(true) {
            try {
                int age = scanner.nextInt();
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

    public String address() {
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        return address;
    }

    public float inputGPA() {
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
