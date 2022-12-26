package com.example.aston_intensive3

import android.app.Activity
import android.content.Intent
import android.os.Bundle

fun <A : Activity> Activity.startActivity(classOfActivity: Class<A>, bundle: Bundle? = null) {
    startActivity(
        Intent(this, classOfActivity).apply {
            bundle?.let {
                this.putExtras(bundle)
            }
        }
    )
}