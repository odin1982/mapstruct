package org.mapstruct.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mapstruct.entity.StudentEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.model.Student;

public class StudentMapperDefaultMethodTest {
	private StudentMapperDefaultMethod studentMapper = Mappers.getMapper(StudentMapperDefaultMethod.class);
	
	public void testStudentMapperDefaultMethod() {
		StudentEntity se = new StudentEntity();
		se.setClassVal("classVal");
		se.setName("odin");
		se.setId(1);
		Student s = studentMapper.getModelFromEntity(se);
		assertEquals(s.getClassName(),se.getClassVal());
		assertEquals(s.getName(),se.getName());
		assertEquals(s.getId(),se.getId());
	}

}
