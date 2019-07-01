package com.daire.application.api

import com.daire.application.models.apierrors.ApiError
import com.daire.application.models.billmodels.Bill
import com.daire.application.persistence.BillOperations
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("api/bills")
class BillController(val billRepository: BillOperations) {

    @PatchMapping("/{id}/setComplete")
    fun completeBill(@PathVariable id: String, @RequestParam("isComplete") isComplete: Boolean): Any {
        val user = billRepository.getUserByBillId(id)
        if (user != null) {
            for (bill in user.bills) {
                if (bill.id == id) {
                    bill.isCompleted = isComplete
                    billRepository.mongoTemplate.save(user)
                    return bill
                }
            }
        }

        throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "a bill with the id $id does not exist"
        )
    }
}