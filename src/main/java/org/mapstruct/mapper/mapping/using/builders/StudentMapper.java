package org.mapstruct.mapper.mapping.using.builders;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.mapping.using.builders.StudentEntity;
import org.mapstruct.model.mapping.using.builders.Student;

@Mapper
public interface StudentMapper {
   Student getModelFromEntity(StudentEntity studentEntity);
   @Mapping(target="id", source="id")
   @Mapping(target="name", source="name")
   StudentEntity getEntityFromModel(Student student);
}