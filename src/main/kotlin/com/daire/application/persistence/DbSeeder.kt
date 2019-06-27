package com.daire.application.persistence

import com.daire.application.models.usermodels.User
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import com.daire.application.models.LegoSet
import org.springframework.data.mongodb.core.MongoTemplate


@Component
class DbSeeder(val mongoTemplate: MongoTemplate) : CommandLineRunner {

    override fun run(vararg args: String?) {

        mongoTemplate.dropCollection(LegoSet::class.java)

        /*
        Lego Sets
         */

//        val falcon = LegoSet(
//                name = "Millennium Falcon",
//                theme = "Star Wars",
//                difficulty = LegoSetDifficulty.HARD,
//                deliveryInfo = DeliveryInfo(LocalDate.now().plusDays(1), 30, true),
//                reviews = Arrays.asList(
//                        ProductReview("Dan", 7),
//                        ProductReview("Anna", 10),
//                        ProductReview("John", 8)
//                ),
//                nbParts = 3)
//
//        val star = LegoSet(
//                name = "Death Star",
//                theme = "Star Wars",
//                difficulty = LegoSetDifficulty.MEDIUM,
//                deliveryInfo = DeliveryInfo(LocalDate.now().plusDays(3), 45, true),
//                reviews = Arrays.asList(
//                        ProductReview("Tom", 7),
//                        ProductReview("User", 10),
//                        ProductReview("John", 8)
//                ),
//                nbParts = 3)

        mongoTemplate.dropCollection(User::class.java)

        val u = User("Tom", "tommo", "tom@tom.com", "mfpomwpofme")
        val u1 = User("Bob", "Bobby", "b@b.com", "b")
        val list = listOf(u, u1)

        mongoTemplate.insertAll(list)

        println("db initialised")
    }
}