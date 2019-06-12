package com.daire.application.api

import com.daire.application.models.LegoSet
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("legostore/api")
class LegoStoreController(val mongoTemplate: MongoTemplate) {

    @PostMapping("/add")
    fun insert(@RequestBody legoSet: LegoSet): LegoSet {
        return mongoTemplate.insert(legoSet)
    }

    @GetMapping("/all")
    fun all(): Collection<LegoSet> {
        return mongoTemplate.findAll(LegoSet::class.java)
    }

    @PutMapping("/update")
    fun update(@RequestBody legoSet: LegoSet){
        mongoTemplate.save(legoSet)
    }

}