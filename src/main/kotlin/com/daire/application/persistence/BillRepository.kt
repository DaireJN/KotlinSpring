package com.daire.application.persistence

import com.daire.application.models.billmodels.Bill
import com.daire.application.models.usermodels.User
import org.springframework.data.mongodb.repository.MongoRepository

interface BillRepository : MongoRepository<Bill, String> {
}