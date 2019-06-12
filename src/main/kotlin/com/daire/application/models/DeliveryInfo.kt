package com.daire.application.models

import java.time.LocalDate

class DeliveryInfo(val deliveryDate: LocalDate,
                   val deliveryFee: Int,
                   val isInStock: Boolean)