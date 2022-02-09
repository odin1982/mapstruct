package org.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.AddressEntity;
import org.mapstruct.entity.StudentEntity;
import org.mapstruct.model.DeliveryAddress;

@Mapper
public interface DeliveryAddressMapper {
	@Mapping(source="student.name",target="name")
	@Mapping(source="address.houseNo",target="houseNumber")
	DeliveryAddress getDeliveryAddress(StudentEntity student, AddressEntity address);
	
	
	@Mapping(source="student.name",target="name")
	@Mapping(source="address.houseNo",target="houseNumber")
	DeliveryAddress getDeliveryAddress(org.mapstruct.entity.mapping.implicit.type.conversion.StudentEntity student, AddressEntity address);
}
