package com.daire.application.persistence

import com.daire.application.models.billmodels.Bill
import com.daire.application.models.usermodels.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserRepository : MongoRepository<User, String> {

    fun deleteByIdAndPassword(id: String, password: String): User

    fun findByNameAndPassword(name: String, password: String): User

    fun findByEmailAndPassword(email: String, password: String): User

    @Query("{'bills._id' : '2' }")
    fun findBillsById(): Collection<User>
}