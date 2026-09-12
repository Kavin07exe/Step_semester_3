package week2.class_problems;

public class CSVStudentRecordParser {

    static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.println(
                "Name: " + name +
                " | Roll No: " + rollNumber +
                " | Dept: " + department
        );
    }

    public static void main(String[] args) {

        String csvLine = "P Kavin,RA2511003011651,CSE";

        parseStudentRecord(csvLine);
    }
}
