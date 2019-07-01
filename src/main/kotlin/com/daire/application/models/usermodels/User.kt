package com.daire.application.models.usermodels

import com.daire.application.models.billmodels.Bill
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document


@Document
class User(
        var name: String = "",
        var displayName: String = "",
        var email: String = "",
        var password: String = "",
        @Indexed
        var bills: MutableList<Bill> = mutableListOf()
) {
    @Id
    var id: String = java.util.UUID.randomUUID().toString()
}