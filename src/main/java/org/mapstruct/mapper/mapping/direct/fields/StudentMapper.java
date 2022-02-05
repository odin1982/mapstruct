package org.mapstruct.mapper.mapping.direct.fields;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.mapping.direct.fields.StudentEntity;
import org.mapstruct.model.mapping.direct.fields.Student;

@Mapper
public interface StudentMapper {
   @Mapping(target="className", source="classVal")
   @Mapping(target="subject", source="subject.name")
   Student getModelFromEntity(StudentEntity studentEntity);

   @InheritInverseConfiguration
   StudentEntity getEntityFromModel(Student student);
}