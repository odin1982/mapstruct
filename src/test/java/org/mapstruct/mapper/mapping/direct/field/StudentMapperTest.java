package org.mapstruct.mapper.mapping.direct.field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.mapping.direct.fields.StudentEntity;
import org.mapstruct.entity.mapping.direct.fields.SubjectEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.mapper.mapping.direct.fields.StudentMapper;
import org.mapstruct.model.mapping.direct.fields.Student;

public class StudentMapperTest {
   private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
   @Test
   public void testEntityToModel() {
      StudentEntity entity = new StudentEntity();
      entity.setClassVal("X");
      entity.setName("John");
      entity.setId(1);
      entity.section = "A";
      SubjectEntity subject = new SubjectEntity();
      subject.setName("Computer");
      entity.setSubject(subject);
      Student model = studentMapper.getModelFromEntity(entity);
      assertEquals(entity.getClassVal(), model.getClassName());
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
      assertEquals(entity.getSubject().getName(), model.getSubject());
      assertEquals(entity.section, model.getSection());	  
   }
   @Test
   public void testModelToEntity() {
      Student model = new Student();
      model.setId(1);
      model.setName("John");
      model.setClassName("X");
      model.setSubject("Science");
      model.setSection("A");
      StudentEntity entity = studentMapper.getEntityFromModel(model);

      assertEquals(entity.getClassVal(), model.getClassName());
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
      assertEquals(entity.getSubject().getName(), model.getSubject());
      assertEquals(entity.section, model.getSection());
   }
}