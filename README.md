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

## Mapping Direct Fields

We'll use @InheritInverseConfiguration annotation to copy reverse configuration now.Lo que hace esta anotacion es el mapeo inverso.

```
@Mapper
public interface StudentMapper {
   @Mapping(target="className", source="classVal")
   @Mapping(target="subject", source="subject.name")
   Student getModelFromEntity(StudentEntity studentEntity);
	
   @InheritInverseConfiguration
   StudentEntity getEntityFromModel(Student student);
}
```

## Implicit Type Conversion

MapStruct handles conversion of type conversions automatically in most of the cases. For example, int to Long or String conversion. Conversion handles null values as well. Following are the some of the important automatic conversions.

* Between primitive types and Corresponding Wrapper Classes.
* Between primitive types and String.
* Between enum types and String.
* Between BigInt, BigDecimal and String.
* Between Calendar/Date and XMLGregorianCalendar.
* Between XMLGregorianCalendar and String.
* Between Jodas date types and String.

```
public class StudentEntity {
   private String id; // Different Type
   private String name;
   private String classVal;
   private SubjectEntity subject;
   public String section;
}

public class Student {
	private final String name; // Different Type
	private final int id;
}
```
