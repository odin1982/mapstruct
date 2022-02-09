package org.mapstruct.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.AddressEntity;
import org.mapstruct.entity.StudentEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.model.DeliveryAddress;

public class DeliveryAddressMapperTest {
	private DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);

	@Test
	public void testEntityToModel() {
		StudentEntity student = new StudentEntity();
		student.setClassVal("X");
		student.setName("John");
		student.setId(1);

		AddressEntity address = new AddressEntity();
		address.setCity("Y");
		address.setState("Z");
		address.setHouseNo(1);

		DeliveryAddress deliveryAddress = deliveryAddressMapper.getDeliveryAddress(student, address);
		assertEquals(deliveryAddress.getName(), student.getName());
		assertEquals(deliveryAddress.getCity(), address.getCity());
		assertEquals(deliveryAddress.getState(), address.getState());
		assertEquals(deliveryAddress.getHouseNumber(), address.getHouseNo());
	}
}
