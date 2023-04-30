package com.example.springhexagonal.domain.user.persistence

import com.example.springhexagonal.domain.user.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {
    fun findByAccountId(accountId: String): UserEntity?
}