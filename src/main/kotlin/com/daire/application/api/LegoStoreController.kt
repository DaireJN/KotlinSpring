package com.daire.application.api

import com.daire.application.models.LegoSet
import com.daire.application.models.LegoSetDifficulty
import com.daire.application.persistence.LegoSetRepository
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("legostore/api")
class LegoStoreController(val legoSetRepository: LegoSetRepository) {

    @PostMapping("/add")
    fun insert(@RequestBody legoSet: LegoSet): LegoSet = legoSetRepository.insert(legoSet)

    @GetMapping("/all")
    fun all(): Collection<LegoSet> {
        return legoSetRepository.findAll(Sort.by("theme").ascending())
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: String) {
        legoSetRepository.deleteById(id)
    }

    @PutMapping("/update")
    fun update(@RequestBody legoSet: LegoSet) {
        legoSetRepository.save(legoSet)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): LegoSet? {
        return legoSetRepository.findById(id).orElse(null)
    }

    @GetMapping("byTheme/{theme}")
    fun byTheme(@PathVariable theme: String): Collection<LegoSet> {
        return legoSetRepository.findAllByThemeContains(theme, Sort.by("theme").ascending())
    }

    @GetMapping("/multiFieldMatch")
    fun multiFieldMatch(): Collection<LegoSet> {
        return legoSetRepository.findAllByDifficultyAndNameContains(LegoSetDifficulty.HARD, "D")
    }

    @GetMapping("/byDeliveryFeeLessThan/{price}")
    fun byDeliveryFeeLessThan(@PathVariable price: Int): Collection<LegoSet> {
        return legoSetRepository.findAllByDeliveryPriceLessThan(price)
    }

    @GetMapping("greatReviews")
    fun greatReviews(): Collection<LegoSet> {
        return legoSetRepository.findAllByGreatReviews()
    }


}