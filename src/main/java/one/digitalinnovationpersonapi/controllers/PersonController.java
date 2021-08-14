package one.digitalinnovationpersonapi.controllers;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import one.digitalinnovationpersonapi.dto.request.PersonDTO;
import one.digitalinnovationpersonapi.dto.response.MessageResponseDTO;
import one.digitalinnovationpersonapi.entities.Person;
import one.digitalinnovationpersonapi.exception.PersonNotFoundException;
import one.digitalinnovationpersonapi.repositories.PersonRepository;
import one.digitalinnovationpersonapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {
        return  personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException  {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}



