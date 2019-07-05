package com.daire.application.api

import com.daire.application.models.billmodels.Bill
import com.daire.application.models.usermodels.User
import com.daire.application.models.usermodels.UserDashboard
import com.daire.application.models.usermodels.UserLoginRequest
import com.daire.application.persistence.DashBoardService
import com.daire.application.persistence.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("api/user")
class UserController(val userRepository: UserRepository, val dashBoardService: DashBoardService) {

    @GetMapping("/all")
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("")
    fun getUserById(@RequestParam("id") id: String): User {
        return userRepository.findById(id).orElse(null)
    }

    @GetMapping("/{id}/bills")
    fun getBillsForUser(@PathVariable("id") id: String): ResponseEntity<Any> {
        val user = userRepository.findById(id).orElse(null)
        return if (user != null) {
            ResponseEntity(user.bills, HttpStatus.OK)
        } else {

            ResponseEntity("The user with the $id does not exist", HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/register")
    fun insertUser(@RequestBody user: User): User = userRepository.insert(user)

    @PostMapping("/delete")
    fun deleteUser(@RequestParam("id") id: String) {
        userRepository.deleteById(id)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: UserLoginRequest): User {
        return when (loginRequest.email.isEmpty()) {
            true -> userRepository.findByNameAndPassword(loginRequest.name, loginRequest.password)
            false -> userRepository.findByNameAndPassword(loginRequest.email, loginRequest.password)
        }
    }

    @GetMapping("/{id}/dashboard")
    fun getUserDashboard(@PathVariable("id") id: String): UserDashboard {
        return dashBoardService.getUserDashBoard(id)[0]
    }

    @PutMapping("/{id}")
    fun addBillToUser(@PathVariable("id") id: String, @RequestBody bill: Bill) {
        val user = userRepository.findById(id).orElse(null)
        if (user != null) {
            user.bills.add(bill)
            userRepository.save(user)
        } else {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "a user with the id $id does not exist"
            )
        }
    }
}