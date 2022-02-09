package org.mapstruct.mapper.mapping.using.builders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.mapping.using.builders.StudentEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.model.mapping.using.builders.Student;

public class StudentMapperTest {
   private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
   
   @Test
   public void testEntityToModel() {
      StudentEntity entity = new StudentEntity();
      entity.setName("John");
      entity.setId(1);
      Student model = studentMapper.getModelFromEntity(entity);
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
   }
   @Test
   public void testModelToEntity() {
      Student.Builder builder = Student.builder().id(1).name("John");
      Student model = builder.create();
      StudentEntity entity = studentMapper.getEntityFromModel(model);
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
   }
}