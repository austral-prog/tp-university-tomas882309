package com.university;

import com.university.CLI.CLI;
import com.university.CLI.CRUDRepository;
import com.university.CLI.StudentRepository;
import com.university.CLI.UniversityCLI;
import com.university.ReaderAndWriter.CsvReader;
import com.university.SolutionsData.SolutionData1;
import com.university.SolutionsData.SolutionData2;
import com.university.SolutionsData.SolutionData3;
import com.university.creators.Creator1;
import com.university.creators.Creator2;
import com.university.creators.Creator3;
import com.university.objects.Student;

public class App {
    public static void main(String[] args) {
        String imputcsv = "src/main/resources/input.csv";
        CsvReader csvReader = new CsvReader(imputcsv);
        Creator1 creator1 = new Creator1(csvReader.getData());

        SolutionData1 Solution1 = new SolutionData1(creator1.getStudents());
        Solution1.Solution();
//        Solution1.sendSolution();



        String imputcsv2 = "src/main/resources/input_2.csv";
        CsvReader csvReader2 = new CsvReader(imputcsv2);
        Creator2 creator2 = new Creator2(csvReader2.getData());

        SolutionData2 Solution2 = new SolutionData2(creator2.getEvaluations());
        Solution2.solution();
//        Solution2.sendSolution();



        String imputcsv3 = "src/main/resources/input_3.csv";
        CsvReader csvReader3 = new CsvReader(imputcsv3);
        Creator3 creator3 = new Creator3(csvReader3.getData(), creator2.getEvaluations());
        creator3.CalculateStatus(csvReader3.getData());

        SolutionData3 Solution3 = new SolutionData3(creator3.getStatus());
        Solution3.Solution();
//        Solution3.sendSolution();



        CRUDRepository<Student> studentRepo = new StudentRepository();
        CLI universityCLI = new UniversityCLI(Solution1.getStringLines(), Solution1.getCountOfCourses());
        CRUDRepository<?>[] crudInterfaces = new CRUDRepository<?>[] { studentRepo };
        universityCLI.runCLI(crudInterfaces);

    }
}
