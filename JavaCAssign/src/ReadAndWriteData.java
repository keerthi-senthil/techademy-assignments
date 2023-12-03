import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteData {
    public static void main(String[] args) {
        try {
            List<Student> students = readExcelData("E:\\techademy\\ComprehensiveAssign\\CourseData.xlsx");
            displayData(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> readExcelData(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            for (int row = 1; row <= sheet.getLastRowNum(); row++) {
                Row currentRow = sheet.getRow(row);
                String name = dataFormatter.formatCellValue(currentRow.getCell(0));
                String courses = dataFormatter.formatCellValue(currentRow.getCell(1));
                String fee = dataFormatter.formatCellValue(currentRow.getCell(2));
                Student student = new Student(name, courses, fee);
                students.add(student);
            }
        }
        return students;
    }

    private static void displayData(List<Student> students) {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Courses: " + student.getCourses());
            System.out.println("Fee: " + student.getFee());
            System.out.println();
        }
    }

    static class Student {
        private String name;
        private String courses;
        private String fee;

        public Student(String name, String courses, String fee) {
            this.name = name;
            this.courses = courses;
            this.fee = fee;
        }
        public String getName() {
            return name;
        }
        public String getCourses() {
            return courses;
        }
        public String getFee() {
            return fee;
        }
    }
}
