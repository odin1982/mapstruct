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


