package com.daire.application.models

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id;

@Document
class PaymentOptions(val type: PaymentType, val fee: Int) {
    @Id
    private val id: String? = null
}