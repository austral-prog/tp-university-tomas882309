package com.university.CLI;

import com.university.CLI.CLI;
import com.university.CLI.CRUDRepository;
import com.university.objects.Student;

import java.util.List;
import java.util.Scanner;

public class UniversityCLI implements CLI {
    private final Scanner scanner = new Scanner(System.in);
    private List<String> studentNames;  // Lista con los nombres de estudiantes
    private List<Integer> courseCounts;  // Lista con el número de cursos de cada estudiante

    // Constructor que acepta las listas de nombres y número de cursos
    public UniversityCLI(List<String> studentNames, List<Integer> courseCounts) {
        this.studentNames = studentNames;
        this.courseCounts = courseCounts;
    }

    @Override
    public void runCLI(CRUDRepository<?>[] crudInterfaces) {
        CRUDRepository<Student> studentRepo = (CRUDRepository<Student>) crudInterfaces[0];

        while (true) {
            System.out.println("Managing Student repository...");
            handleCRUDOperations(studentRepo);
        }
    }

    private <T extends com.university.CLI.Entity> void handleCRUDOperations(CRUDRepository<T> repository) {
        System.out.println("Choose an operation: [1] Create, [2] Read, [3] Update, [4] Delete");
        int operation = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        switch (operation) {
            case 1 -> createEntity(repository);
            case 2 -> readEntity(repository);
            case 3 -> updateEntity(repository);
            case 4 -> deleteEntity(repository);
            default -> System.out.println("Invalid operation.");
        }
    }

    // Método createEntity para agregar el nuevo estudiante a las listas de nombres y cursos
    private <T extends com.university.CLI.Entity> void createEntity(CRUDRepository<T> repository) {
        if (repository.getEntityClass().getSimpleName().equals("Student")) {
            System.out.println("Creating a new student...");

            // Solicitar datos del nuevo estudiante
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter number of courses: ");
            int courseCount = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            // Agregar el nuevo estudiante a las listas
            studentNames.add(name);
            courseCounts.add(courseCount);

            System.out.println("Student created successfully.");
        } else {
            System.out.println("Entity type not supported for creation.");
        }
    }

    // Método para leer todos los estudiantes (simplemente muestra las listas)
    private <T extends com.university.CLI.Entity> void readEntity(CRUDRepository<T> repository) {
        if (repository.getEntityClass().equals(Student.class)) {
            System.out.println("Displaying all students:");
            int j = 0;
            for (int i = 0; i < studentNames.size(); i++) {
                System.out.println("id:" + j + ", Student: " + studentNames.get(i) + ", Courses Enrolled: " + courseCounts.get(i));
                j++;
            }
        } else {
            System.out.println("Entity type not supported for reading.");
        }
    }

    // Método para actualizar un estudiante existente
    private <T extends com.university.CLI.Entity> void updateEntity(CRUDRepository<T> repository) {
        if (repository.getEntityClass().getSimpleName().equals("Student")) {
            System.out.println("Enter the index of the student to update: ");
            int index = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            if (index >= 0 && index < studentNames.size()) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new course count: ");
                int newCourseCount = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea

                // Actualizar el nombre y el número de cursos
                studentNames.set(index, newName);
                courseCounts.set(index, newCourseCount);

                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Invalid student index.");
            }
        } else {
            System.out.println("Entity type not supported for updating.");
        }
    }

    // Método para eliminar un estudiante existente
    private <T extends com.university.CLI.Entity> void deleteEntity(CRUDRepository<T> repository) {
        if (repository.getEntityClass().getSimpleName().equals("Student")) {
            System.out.println("Enter the index of the student to delete: ");
            int index = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            if (index >= 0 && index < studentNames.size()) {
                // Eliminar el estudiante de las listas
                studentNames.remove(index);
                courseCounts.remove(index);
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Invalid student index.");
            }
        } else {
            System.out.println("Entity type not supported for deletion.");
        }
    }
}