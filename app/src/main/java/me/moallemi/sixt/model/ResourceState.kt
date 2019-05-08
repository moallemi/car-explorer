package me.moallemi.sixt.model

import java.io.Serializable

enum class ResourceState : Serializable {
    SUCCESS,
    LOADING,
    ERROR
}