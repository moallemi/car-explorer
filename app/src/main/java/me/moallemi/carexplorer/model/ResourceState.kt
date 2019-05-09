package me.moallemi.carexplorer.model

import java.io.Serializable

enum class ResourceState : Serializable {
    SUCCESS,
    LOADING,
    ERROR
}