package br.com.rubinhomaroti.webflux.controller

import br.com.rubinhomaroti.webflux.dto.CreatePersonDTO
import br.com.rubinhomaroti.webflux.dto.PersonDTO
import br.com.rubinhomaroti.webflux.service.PersonService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("persons")
class PersonController(
    private val personService: PersonService
) {
    @GetMapping
    fun list(): Flux<PersonDTO> = personService.list()

    @PostMapping
    fun create(@RequestBody createPersonDTO: CreatePersonDTO) : Mono<PersonDTO>
        = personService.save(createPersonDTO)
}