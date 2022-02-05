package org.mapstruct.mapper.mapping.nested.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.AddressEntity;
import org.mapstruct.entity.mapping.nested.bean.StudentEntity;
import org.mapstruct.entity.mapping.nested.bean.SubjectEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.model.DeliveryAddress;
import org.mapstruct.model.mapping.nested.bean.Student;

public class StudentMapperTest {
   private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
   @Test
   public void testEntityToModel() {
      StudentEntity entity = new StudentEntity();
      entity.setClassVal("X");
      entity.setName("John");
      entity.setId(1);

      SubjectEntity subject = new SubjectEntity();
      subject.setName("Computer");
      entity.setSubject(subject);

      Student model = studentMapper.getModelFromEntity(entity);

      assertEquals(entity.getClassVal(), model.getClassName());
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
      assertEquals(entity.getSubject().getName(), model.getSubject());        
   }
   @Test
   public void testModelToEntity() {
      Student model = new Student();
      model.setId(1);
      model.setName("John");
      model.setClassName("X");
      model.setSubject("Science");
      StudentEntity entity = studentMapper.getEntityFromModel(model);
      assertEquals(entity.getClassVal(), model.getClassName());
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
      assertEquals(entity.getSubject().getName(), model.getSubject());
   }
}