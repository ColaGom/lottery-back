package com.colagom.lottery.domain


data class LotteryResponse(
    val _paging: Pagination,
    val items: List<Lottery>
)

data class Pagination(
    val hasMore: Boolean
)