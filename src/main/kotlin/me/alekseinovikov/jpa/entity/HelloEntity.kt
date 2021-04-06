package me.alekseinovikov.jpa.entity

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "hello")
data class HelloEntity(

    @field:Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @NotNull
    @Column(name = "hello", nullable = false)
    var hello: String = ""

)