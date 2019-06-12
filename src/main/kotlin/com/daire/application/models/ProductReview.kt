package com.daire.application.models

import org.springframework.data.mongodb.core.index.TextIndexed

class ProductReview(@field:TextIndexed
                    val userName: String, val rating: Int)