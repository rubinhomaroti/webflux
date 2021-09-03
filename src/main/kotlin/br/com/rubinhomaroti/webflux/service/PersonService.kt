package br.com.rubinhomaroti.webflux.service

import br.com.rubinhomaroti.webflux.dto.CreatePersonDTO
import br.com.rubinhomaroti.webflux.dto.PersonDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PersonService {
    fun save(createPersonDTO: CreatePersonDTO): Mono<PersonDTO>
    fun list(): Flux<PersonDTO>
}