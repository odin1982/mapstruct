package org.mapstruct.mapper.mapping.using.numberFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.mapping.using.numberFormat.CarEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.model.mapping.using.numberFormat.Car;

public class carMapperTest {
	private CarMapper carMapper = Mappers.getMapper(CarMapper.class);

	@Test
	public void testEntityToModel() {
		CarEntity entity = new CarEntity();
		entity.setPrice(345000);
		entity.setId(1);
		Car model = carMapper.getModelFromEntity(entity);
		assertEquals(model.getPrice(), "$345000.00");
		assertEquals(entity.getId(), model.getId());
	}
}
