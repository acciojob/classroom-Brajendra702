package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

   //First API
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){

        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }
     //Second API
    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){

        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }
    //API to add Pair of Student
    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){

        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }
    //Get Api to get Student name
    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = null; // Assign student by calling service layer method

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    //Get Api to get teacher by name
    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = null; // Assign student by calling service layer method

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }
    //Api to get student and teacher
    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = null; // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }
     //API to get all student
    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = null; // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }
    //Api to delete Teacher by name
    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){

        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }
    //Api to delete all teacher
    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){

        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}
