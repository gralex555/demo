package com.example.demo.service;

import com.example.demo.aop.LogExecutionTime;
import com.example.demo.entity.Department;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.impl.PersonService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.io.InterruptedIOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImplementation implements PersonService {
   final PersonRepository personRepository;

// Required - если транзакция существует, то присоединяемся к ней. Если нет, то создаем новую.
// Supports - метод выполняется в Транзаакции если она есть, если нет, то без нее.
// Mandatory - метод должен быть вызван внутри транзакции, иначе - исключение
// Not supported - метод не будет выролняться в транзации.  Если он был вызван, то текущая транзакция останавливается
// NEVER - метод должен аыполняться без транзакции иначе - исключение
// Nested создает вложенную тразакцию. Если тразакция упадет, то откатится только вложенная транзакция, а основная не пострадает
    @Override
    @Transactional
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    @LogExecutionTime(value = "замер задержки поиска по id", lifeCycle = 555)
    public Person findPersonById(Long id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        return personRepository.findById(id).orElseThrow();
        // проверяет данные и выкидывает исключение
    }
    @Override
    public Optional<Person>findById(long id){
        return personRepository.findById(id);
    }

    @Override
    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }
    /// добавил /////////////////
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findByDepartment(Department department) {
        return personRepository.findByDepartment(department);
    }


    @Override
    public void update(long id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
