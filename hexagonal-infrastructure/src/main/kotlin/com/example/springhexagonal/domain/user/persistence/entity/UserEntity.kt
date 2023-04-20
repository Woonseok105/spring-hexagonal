package com.example.springhexagonal.domain.user.persistence.entity

import com.example.springhexagonal.global.entity.BaseIdEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_user")
class UserEntity (

        id: Long,

        accountId: String,

        password: String,

) : BaseIdEntity(id) {

    @field:NotNull
    var accountId = accountId

    @field:NotNull
    var password = password
}
