package com.daire.application.persistence

import com.daire.application.models.usermodels.User
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Service

@Service
class BillOperations(val mongoTemplate: MongoTemplate) {
    fun getUserByBillId(id: String): User? {
        val query = org.springframework.data.mongodb.core.query.Query()
        query.addCriteria(Criteria.where("bills").elemMatch(Criteria.where("id").`is`(id)))
        return mongoTemplate.findOne(query, User::class.java)
    }
}