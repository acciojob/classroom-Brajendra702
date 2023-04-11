package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String ,Student> studentHashMap=new HashMap<>();
    HashMap<String ,Teacher> teacherHashMap=new HashMap<>();
    HashMap<String, List<String>> teacherStudentHashMap=new HashMap<>();

    public void addStudent(Student student) {
        studentHashMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
       List<String> studentCombination=new ArrayList<>();
       if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher)){
           if(teacherHashMap.containsKey(teacher)) studentCombination=teacherStudentHashMap.get(teacher);
           studentCombination.add(student);
           teacherStudentHashMap.put(teacher,studentCombination);
           //for particular teacher how many student he is traching
           Teacher t=teacherHashMap.get(teacher);
           t.setNumberOfStudents(studentCombination.size());
       }

    }

    public void deleteAllTeachers() {
        for(String tname:teacherHashMap.keySet()){
            if(teacherStudentHashMap.containsKey(tname)){
                for(String sname:teacherStudentHashMap.get(tname))
                    studentHashMap.remove(sname);
            }
            else{
                teacherHashMap.remove(tname);
            }
        }
    }

    public void deleteTeacherByName(String teacher) {
        if(teacherStudentHashMap.containsKey(teacher) && teacherHashMap.containsKey(teacher)){
            for (String sname:teacherStudentHashMap.get(teacher))
                studentHashMap.remove(sname);
            teacherStudentHashMap.remove(teacher);
        }
    }

    public List<String> getAllStudent() {
        return  new ArrayList<>(studentHashMap.keySet());
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String>studentList=new ArrayList<>();
        if(teacherStudentHashMap.containsKey(teacher))
            studentList=teacherStudentHashMap.get(teacher);
        return studentList;
    }

    public Teacher getTeacherByName(String name) {
        return teacherHashMap.get(name);
    }

    public Student getStudentByName(String name) {
        return studentHashMap.get(name);
    }
}
