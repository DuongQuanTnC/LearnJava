package QuanLySinhVien;

import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StudentManagament studentManagament = new StudentManagament();
        Scanner scanner = new Scanner(System.in);
        String s;
        do {
            showMenu();
            System.out.print("\nChon tinh nang: ");
            int i = scanner.nextInt();
            switch (i) {
                case 1: {
                    do {
                        scanner.nextLine();
                        studentManagament.add();
                        System.out.print("Ban muon them sinh vien nua khong [y/n]: ");
                        s = scanner.next();
                    } while (Objects.equals(s, "y"));

                    break;
                }
                case 2: {
                    System.out.println("Nhap ID muon xoa khoi danh sach");
                    int id = studentManagament.inputId();
                    studentManagament.delete(id);
                    break;
                }
                case 3: {
                    System.out.println("Sua lai thong tin sinh vien");
                    int id = studentManagament.inputId();

                    studentManagament.edit(id);
                    break;
                }
                case 4: {
                    studentManagament.sortStudentByName();
                    studentManagament.show();
                    break;
                }
                case 5: {
                    studentManagament.sortStudentByGpa();
                    studentManagament.show();
                    break;
                }
                case 6: {
                    studentManagament.sortStudentbyId();
                    studentManagament.show();
                    break;
                }

                case 7: {
                    return;
                }
            }
            if(scanner.hasNextLine()) {
                scanner.nextLine();
                System.out.print("Nhan 'y' de tro ve menu: ");
                s = scanner.nextLine();
                System.out.println("\n");
            }
            else {
                System.out.print("Nhan 'y' de tro ve menu: ");
                s = scanner.nextLine();
                System.out.println("\n");
            }
        } while (Objects.equals(s, "y"));
    }
    public static void showMenu() {
        System.out.println("1. Them sinh vien");
        System.out.println("2. Xoa sinh vien");
        System.out.println("3. Sua sinh vien");
        System.out.println("4. Sap xep theo ten");
        System.out.println("5. Sap xep theo GPA");
        System.out.println("6. Hien thi danh sach");
        System.out.println("7. Thoat");
    }
}



