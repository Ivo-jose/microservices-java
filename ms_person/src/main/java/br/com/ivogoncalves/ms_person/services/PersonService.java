package br.com.ivogoncalves.ms_person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivogoncalves.ms_person.exceptions.ResourceNotFoundException;
import br.com.ivogoncalves.ms_person.models.Person;
import br.com.ivogoncalves.ms_person.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public Person findById(Long id) {
		log.info("Finding one person by id: {}", id);
		return repository.findById(Long.valueOf(id)).
					orElseThrow(() -> new ResourceNotFoundException("No records found this ID! - ID: " + id));
	}

	public List<Person> findAll() {
		log.info("Finding all people");
		return repository.findAll();
	}
	
	public Person create(Person person) {
		log.info("Creating one person: {}", person);
		return repository.save(person);
	}
	
	public Person update(Person newPerson) {
		log.info("Updating one person: {}", newPerson);
		var oldPerson = findById(newPerson.getId());
		oldPerson = setAttributesForUpdate(newPerson, oldPerson);
		return repository.save(oldPerson);
		
	}
	
	public void delete(Long id) {
		log.info("Deleting one person by id: {}", id);
		var person = findById(id);
		repository.delete(person);
	}
	
	/**
	 * This method is used to set the attributes of the old entity with the new entity.
	 * 
	 * @param newEntity
	 * @param oldEntity
	 * @return
	 */
	private Person setAttributesForUpdate(Person newEntity, Person oldEntity) {
		oldEntity.setFirstName(newEntity.getFirstName());
		oldEntity.setLastName(newEntity.getLastName());
		oldEntity.setAddress(newEntity.getAddress());
		oldEntity.setGender(newEntity.getGender());
		return oldEntity;
	}
}
