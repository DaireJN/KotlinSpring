package com.daire.application.api

import com.daire.application.models.LegoSet
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("legostore/api")
class LegoStoreController(val mongoTemplate: MongoTemplate) {

    @PostMapping
    fun insert(@RequestBody legoSet: LegoSet): LegoSet {
        mongoTemplate.insert(legoSet)
        return legoSet
    }

    @GetMapping("/all")
    fun all(): Collection<LegoSet> {
        return mongoTemplate.findAll(LegoSet::class.java)
    }

}