package com.daire.application.api

import com.daire.application.models.billmodels.Bill
import com.daire.application.models.usermodels.User
import com.daire.application.persistence.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/user")
class UserController(val userRepository: UserRepository) {

    @GetMapping("/all")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("")
    fun getUserById(@RequestParam("id") id: String): User {
        return userRepository.findById(id).orElse(null)
    }

    @PostMapping("/create")
    fun insertUser(@RequestBody user: User): User = userRepository.insert(user)

    @PostMapping("/delete")
    fun deleteUser(@RequestParam("id") id: String) {
        userRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun addBillToUser(@PathVariable("id") id: String, @RequestBody bill: Bill) {
        val user = userRepository.findById(id)
        user.ifPresent {
            user.get().bills.add(bill)
            userRepository.save(it)
        }
    }
}