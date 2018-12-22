package ru.lapov.forrabitresult.models

data class DividerItemModel(val title: String)

data class RowItemModel(val time: String,
                        val title: String,
                        val score: String,
                        val coef1: String,
                        val coef2: String,
                        val coef3: String,
                        val result: String)