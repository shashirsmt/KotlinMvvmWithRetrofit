package com.tr.mvvmwithretrofit.models

data class list(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultX>,
    val totalCount: Int,
    val totalPages: Int
)