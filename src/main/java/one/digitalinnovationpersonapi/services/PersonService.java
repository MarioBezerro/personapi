package one.digitalinnovationpersonapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovationpersonapi.dto.mapper.PersonMapper;
import one.digitalinnovationpersonapi.dto.request.PersonDTO;
import one.digitalinnovationpersonapi.dto.response.MessageResponseDTO;
import one.digitalinnovationpersonapi.entities.Person;
import one.digitalinnovationpersonapi.exception.PersonNotFoundException;
import one.digitalinnovationpersonapi.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return  allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
       personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public MessageResponseDTO updateById(long id, PersonDTO personDTO) throws PersonNotFoundException  {
        verifyIfExists(id);

        Person personToUpdate = PersonMapper.INSTANCE.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {
        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
}