package br.com.rubinhomaroti.webflux.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Person (
    @Id
    val id: String? = null,
    val name: String,
)