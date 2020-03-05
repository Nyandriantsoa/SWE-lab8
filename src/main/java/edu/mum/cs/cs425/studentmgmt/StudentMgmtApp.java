package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repositories.StudentRepository;

@Component
public class StudentMgmtApp implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Student s1 = new Student("000-61-0001" , "Anna" , "Lynn", "Smith", 3.45f, LocalDate.of(2019, 5, 24));
		
		Transcript transcript = new Transcript("BS Computer Science");
		s1.addTranscript(transcript);
		
		Classroom classroom = new Classroom("McLaughlin building", "M105");
		s1.setClassroom(classroom);
		
		this.saveStudent(s1);
		
	}
	
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}

}
