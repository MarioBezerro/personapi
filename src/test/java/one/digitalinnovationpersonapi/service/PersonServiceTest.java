//package one.digitalinnovationpersonapi.service;
//
//import one.digitalinnovationpersonapi.dto.mapper.PersonMapper;
//import one.digitalinnovationpersonapi.dto.request.PersonDTO;
//import one.digitalinnovationpersonapi.dto.response.MessageResponseDTO;
//import one.digitalinnovationpersonapi.entities.Person;
//import one.digitalinnovationpersonapi.repositories.PersonRepository;
//import one.digitalinnovationpersonapi.services.PersonService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static one.digitalinnovationpersonapi.utils.PersonUtils.createFakeDTO;
//import static one.digitalinnovationpersonapi.utils.PersonUtils.createFakeEntity;
//import static org.hamcrest.Matchers.any;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class PersonServiceTest {
//
//    @Mock
//    private PersonRepository personRepository;
//
//    @Mock
//    private PersonMapper personMapper;
//
//    @InjectMocks
//    private PersonService personService;
//
//    @Test
//    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
//        PersonDTO personDTO = createFakeDTO();
//        Person expectedSavedPerson = createFakeEntity();
//
//        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
//        //when(personRepository.save(any(Person.class)).thenReturn(expectedSavedPerson);
//
//        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
//        MessageResponseDTO successMessage = personService.create(personDTO);
//
//        assertEquals(expectedSuccessMessage, successMessage);
//    }
//
//    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
//        return MessageResponseDTO.builder()
//                .message("Person successfully created with ID " + savedPersonId)
//                .build();
//    }
//
//}