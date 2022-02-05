package org.mapstruct.mapper.mapping.nested.bean;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.mapping.nested.bean.StudentEntity;
import org.mapstruct.model.mapping.nested.bean.Student;

@Mapper
public interface StudentMapper {
   @Mapping(target="className", source="classVal")
   @Mapping(target="subject", source="subject.name")
   Student getModelFromEntity(StudentEntity studentEntity);

   @Mapping(target="classVal", source="className")
   @Mapping(target="subject.name", source="subject")
   StudentEntity getEntityFromModel(Student student);
}