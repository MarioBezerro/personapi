package one.digitalinnovationpersonapi.dto.mapper;

import one.digitalinnovationpersonapi.dto.request.PersonDTO;
import one.digitalinnovationpersonapi.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
