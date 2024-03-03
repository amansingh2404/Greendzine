package com.example.greendzine.ui.auth

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class UserDetails: RealmObject {
     var email: String = ""
    var userName : String = ""
    var password: String = ""

}