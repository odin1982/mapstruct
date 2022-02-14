package org.mapstruct.mapper.mapping.using.dateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import org.mapstruct.entity.mapping.using.dateFormat.CarEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.model.mapping.using.dateFormat.Car;

public class CarMapperTest {
   private CarMapper carMapper = Mappers.getMapper(CarMapper.class);

   @Test
   public void testEntityToModel() {
      CarEntity entity = new CarEntity();
      entity.setPrice(345000);
      entity.setId(1);
      entity.setManufacturingDate(new GregorianCalendar(2015, 3, 5));
      Car model = carMapper.getModelFromEntity(entity);
      assertEquals(model.getPrice(), "$345000.00");
      assertEquals(entity.getId(), model.getId());
      assertEquals("05.04.2015", model.getManufacturingDate());
   }
}