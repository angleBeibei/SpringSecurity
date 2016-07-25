package com.service;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.beans.Student;
@Service
public class StudentService {
	Map<Integer, Student> map = new HashMap<Integer,Student>();
	{
		map.put(1, new Student(1, "Ram"));
		map.put(2, new Student(2, "Shyam"));
		map.put(3, new Student(3, "Rahim"));
	}
	public String getStudentName(int id) {
		System.out.println("Fetching student for the id:"+ id);
		Student std = map.get(id);
		return std.getStdName();
	}
} 