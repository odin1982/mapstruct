package org.mapstruct.mapper.mapping.using.dateFormat;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.entity.mapping.using.dateFormat.CarEntity;
import org.mapstruct.model.mapping.using.dateFormat.Car;

@Mapper
public interface CarMapper {
   @Mapping(source = "price", target = "price", numberFormat = "$#.00")
   @Mapping(source = "manufacturingDate", target = "manufacturingDate", dateFormat = "dd.MM.yyyy")
   Car getModelFromEntity(CarEntity carEntity);
}