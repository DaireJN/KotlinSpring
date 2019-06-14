package com.daire.application.persistence

import com.daire.application.models.LegoSet
import com.daire.application.models.LegoSetDifficulty
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface LegoSetRepository : MongoRepository<LegoSet, String> {

    fun findAllByThemeContains(theme: String, sort: Sort): Collection<LegoSet>

    fun findAllByDifficultyAndNameContains(legoSetDifficulty: LegoSetDifficulty, name: String): Collection<LegoSet>

    @Query("{'delivery.deliveryFee' : {\$lt : ?0}}")
    fun findAllByDeliveryPriceLessThan(price: Int): Collection<LegoSet>

    @Query("{'reviews.rating' : {\$eq : 10}}")
    fun findAllByGreatReviews(): Collection<LegoSet>
}