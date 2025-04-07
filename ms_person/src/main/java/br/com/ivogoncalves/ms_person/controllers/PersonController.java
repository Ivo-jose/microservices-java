package br.com.ivogoncalves.ms_person.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ivogoncalves.ms_person.models.Person;
import br.com.ivogoncalves.ms_person.services.PersonService;




@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Person> create(@RequestBody Person person) {
		var newPerson = service.create(person);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newPerson.getId())
				.toUri();
		return ResponseEntity.created(location).body(newPerson);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Person> update(@RequestBody Person person) {
		return ResponseEntity.ok().body(service.update(person));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
