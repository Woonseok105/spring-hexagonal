package com.example.springhexagonal.domain.user.persistence

import com.example.springhexagonal.domain.user.domain.User
import com.example.springhexagonal.domain.user.mapper.UserMapper
import com.example.springhexagonal.domain.user.spi.UserPort
import com.example.springhexagonal.domain.user.exception.UserNotFoundException
import com.example.springhexagonal.global.annotation.Adaptor

@Adaptor
class UserPersistenceAdapter (
        private val userRepository: UserRepository,
        private val userMapper: UserMapper
) : UserPort {
    override fun queryUserByAccountId(accountId: String): User {
        return userMapper.entityToDomain(
                userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
        )
    }

    override fun saveUser(user: User) {
        userRepository.save(userMapper.domainToEntity(user))
    }
}