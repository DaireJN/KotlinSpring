package com.daire.application.api

import com.daire.application.persistence.BillRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/bills")
class BillController(val billrepository: BillRepository) {
    @PatchMapping("/{id}")
    fun completeBill(@PathVariable("id") id: String) {
        val bill = billrepository.findById(id)
        bill.ifPresent { billResult ->
            billResult.isCompleted = true
            billrepository.save(billResult)
        }
    }
}