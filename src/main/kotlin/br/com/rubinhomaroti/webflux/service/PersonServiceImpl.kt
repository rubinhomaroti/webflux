package br.com.rubinhomaroti.webflux.service

import br.com.rubinhomaroti.webflux.document.Person
import br.com.rubinhomaroti.webflux.dto.CreatePersonDTO
import br.com.rubinhomaroti.webflux.dto.PersonDTO
import br.com.rubinhomaroti.webflux.repository.PersonRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository
) : PersonService {
    override fun save(createPersonDTO: CreatePersonDTO): Mono<PersonDTO> = Mono.just(createPersonDTO)
        .map { Person(name = it.name) }
        .flatMap { personRepository.save(it) }
        .map { PersonDTO(id = it?.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), name = it.name) }

    override fun list(): Flux<PersonDTO> = personRepository.findAll()
        .map { PersonDTO(id = it?.id ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST), name = it.name) }
}