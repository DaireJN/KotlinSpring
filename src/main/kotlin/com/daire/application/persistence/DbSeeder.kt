package com.daire.application.persistence

import com.daire.application.models.usermodels.User
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import com.daire.application.models.billmodels.Bill
import com.daire.application.models.billmodels.BillType
import org.springframework.data.mongodb.core.MongoTemplate


@Component
class DbSeeder(val mongoTemplate: MongoTemplate) : CommandLineRunner {

    override fun run(vararg args: String?) {

        //mongoTemplate.dropCollection(User::class.java)

        val b = Bill("PS4", BillType.EVEN)
        b.id = "2"

        val u = User("Tom", "tommo", "tom@tom.com", "mfpomwpofme")
        val u1 = User("Bob", "Bobby", "b@b.com", "b")
        val u2 = User("test", "test", "test@gmail.com", "tester", mutableListOf(b))
        u2.id = "1"
        val list = listOf(u, u1, u2)

        //mongoTemplate.insertAll(list)

        println("db initialised")
    }
}