package org.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.StudentEntity;
import org.mapstruct.model.Student;

@Mapper
public interface StudentMapper {
	
	@Mapping(target="className", source="classVal")
	Student getModelFromEntity(StudentEntity studentEntity);
	
	@Mapping(target="classVal", source="className")
	StudentEntity getEntityFromModel(Student student);

}
