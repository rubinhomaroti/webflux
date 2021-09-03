package br.com.rubinhomaroti.webflux.repository

import br.com.rubinhomaroti.webflux.document.Person
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PersonRepository : ReactiveMongoRepository<Person, String>