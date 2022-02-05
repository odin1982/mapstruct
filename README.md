# Mapstruct
```
Librería que nos permite hacer mapeos sin necesidad de escribir codigo a mano.
```

## When mapping is required?
In mutilayered applications, data objects are used to fecth data from database and UI interacts with models.


## Mapeo sencillo
- Crear una interface

CASO-1: En caso de que los atributos de las clases se llamen igual con esto es mas que suficiente.

```
@Mapper
public interface StudentMapper{
    Student maptoEntity(StudentEntity student);
}
```

CASO-2: En caso de que los atributos sean llamados con diferente nombre.

```
@Mapper
public interface StudentMapper{
    @Mapping(target="className", source="classVal")
    Student maptoEntity(StudentEntity student);
}
```

## 3 Formas de crear tu Mapper

### Interface

```
@Mapper
public interface StudentMapper{
    Student maptoEntity(StudentEntity student);
}
```

### Interface with DEFAULT method

```
@Mapper
public interface StudentMapper {
   default Student getModelFromEntity(StudentEntity studentEntity){
      Student student = new Student();
      student.setId(studentEntity.getId());
      student.setName(studentEntity.getName());
      student.setClassName(studentEntity.getClassVal());
      return student;
   }
}
```

### Abstract class

```
@Mapper
public absgract class StudentMapper {
   Student getModelFromEntity(StudentEntity studentEntity){
      Student student = new Student();
      student.setId(studentEntity.getId());
      student.setName(studentEntity.getName());
      student.setClassName(studentEntity.getClassVal());
      return student;
   }
}
```

## Mapping multiple Objects

```
@Mapper
public interface DeliveryAddressMapper {
	@Mapping(source="student.name",target="name")
	@Mapping(source="address.houseNo",target="houseNumber")
	DeliveryAddress getDeliveryaddress(StudentEntity student, AddressEntity address);
}
```

## Mapping nested beans

```
@Mapper
public interface StudentMapper {
   @Mapping(target="className", source="classVal")
   @Mapping(target="subject", source="subject.name")
   Student getModelFromEntity(StudentEntity studentEntity);
	
   @Mapping(target="classVal", source="className")
   @Mapping(target="subject.name", source="subject")
   StudentEntity getEntityFromModel(Student student);
}
```