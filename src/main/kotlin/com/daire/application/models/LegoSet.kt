package com.daire.application.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "legosets")
class LegoSet(
        @TextIndexed
        var name: String = "",
        var difficulty: LegoSetDifficulty,
        @TextIndexed
        @Indexed(direction = IndexDirection.ASCENDING)
        var theme: String = "",
        var reviews: Collection<ProductReview> = listOf(),
        @Field("delivery")
        var deliveryInfo: DeliveryInfo? = null,
        @DBRef
        var paymentOptions: PaymentOptions? = null,
        var nbParts: Int
) {
    @Id
    var id: String = java.util.UUID.randomUUID().toString()
}