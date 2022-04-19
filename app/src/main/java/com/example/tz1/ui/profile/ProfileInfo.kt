package com.example.tz1.ui.profile

class ProfileInfo (private val name: String,
                   private val secName: String,
                   private val institute: String,
                   private val kafedra: String,
                   private val group: String) {

    fun getName() = name
    fun getSecName() = secName
    fun getInstitute() = institute
    fun getKafedra() = kafedra
    fun getGroup() = group
}