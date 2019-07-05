package com.daire.application.persistence

import com.daire.application.models.usermodels.User
import com.daire.application.models.usermodels.UserDashboard
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.Aggregation.*
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation
import org.springframework.stereotype.Service
import org.springframework.data.mongodb.core.aggregation.MatchOperation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.aggregation.OutOperation


@Service
class DashBoardService(private val mongoTemplate: MongoTemplate) {

    fun getUserDashBoard(id: String): MutableList<UserDashboard> {

        val matchOperation = match(Criteria.where("id").`is`(id))

        val projectToMatchModel = project()
                .andExpression("name").`as`("name")
                .andExpression("email").`as`("email")
                .andExpression("bills").`as`("bills")

        val avgRatingAggregation = newAggregation(matchOperation, projectToMatchModel)

        return mongoTemplate.aggregate(avgRatingAggregation, User::class.java, UserDashboard::class.java).mappedResults
    }
}