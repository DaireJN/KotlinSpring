package com.daire.application.models.usermodels

import com.daire.application.models.billmodels.Bill

class UserDashboard(
        var name: String = "",
        var email: String = "",
        var bills: List<Bill> = listOf()
)