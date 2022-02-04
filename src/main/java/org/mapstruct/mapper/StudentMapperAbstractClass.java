package org.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.entity.StudentEntity;
import org.mapstruct.model.Student;

@Mapper
public abstract class StudentMapperAbstractClass {
	
	Student getModelFromEntity(StudentEntity studentEntity) {
		Student student = new Student();
		student.setId(studentEntity.getId());
		student.setName(studentEntity.getName());
		student.setClassName(studentEntity.getClassVal());
		return student;
	}

}
