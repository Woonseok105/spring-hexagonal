package com.example.springhexagonal.domain.user.mapper

import com.example.springhexagonal.domain.user.domain.User
import com.example.springhexagonal.domain.user.persistence.entity.UserEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun entityToDomain(userEntity: UserEntity): User = userEntity.let {
        User(
                id = it.id,
                accountId = it.accountId,
                password = it.password
        )
    }

    fun domainToEntity(user: User): UserEntity = user.let {
        UserEntity(
                id = it.id,
                accountId = it.accountId,
                password = it.password
        )
    }
}