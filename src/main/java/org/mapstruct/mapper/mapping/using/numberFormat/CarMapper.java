package org.mapstruct.mapper.mapping.using.numberFormat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.mapping.using.numberFormat.CarEntity;
import org.mapstruct.model.mapping.using.numberFormat.Car;

@Mapper
public interface CarMapper {
	@Mapping(source = "price", target = "price", numberFormat = "$#.00" )
	Car getModelFromEntity(CarEntity carEntity);
}
