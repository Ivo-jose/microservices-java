package br.com.ivogoncalves.ms_person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ivogoncalves.ms_person.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
