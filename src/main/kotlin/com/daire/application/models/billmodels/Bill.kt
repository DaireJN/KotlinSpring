package com.daire.application.models.billmodels

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

class Bill(
        var name: String = "",
        var type: BillType,
        var serviceCharge: Double? = null,
        var tip: Double? = null,
        var total: Double? = null,
        var isCompleted: Boolean = false
) {
    @Id
    var id: String = java.util.UUID.randomUUID().toString()
}