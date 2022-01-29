package mapstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.StudentEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.mapper.StudentMapper;
import org.mapstruct.model.Student;

public class StudentMapperTest {
	private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

	@Test
	public void testEntityToModel() {
		StudentEntity entity = new StudentEntity();
		entity.setClassVal("X");
		entity.setName("John");
		entity.setId(1);
		Student model = studentMapper.getModelFromEntity(entity);
		assertEquals(entity.getClassVal(), model.getClassName());
		assertEquals(entity.getName(), model.getName());
		assertEquals(entity.getId(), model.getId());
	}

}
