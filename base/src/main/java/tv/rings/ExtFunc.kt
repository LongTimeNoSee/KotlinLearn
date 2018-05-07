package tv.rings

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.support.annotation.IdRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


/**
 * Created by Burhanuddin on 2/21/2018.
 */

inline fun AppCompatActivity.loadFragment(isAddToBackStack: Boolean = false,
                                          transitionPairs: Map<String, View> = mapOf(),
                                          transaction: FragmentTransaction.() -> Unit) {
    val beginTransaction = supportFragmentManager.beginTransaction()
    beginTransaction.transaction()
    for ((name, view) in transitionPairs) {
        ViewCompat.setTransitionName(view, name)
        beginTransaction.addSharedElement(view, name)
    }

    if (isAddToBackStack) beginTransaction.addToBackStack(null)
    beginTransaction.commit()
}

fun Activity.isPortrait() = requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

fun Activity.getDeviceWidth() = with(this) {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    displayMetrics.widthPixels
}

fun Activity.getDeviceHeight() = with(this) {
    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)
    displayMetrics.heightPixels
}

fun Fragment.toast(message: String, isLong: Boolean = false) {
    Toast.makeText(this.activity, message, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.removeFragmentByTag(tag: String): Boolean {
    return removeFragment(supportFragmentManager.findFragmentByTag(tag))
}

fun AppCompatActivity.removeFragmentByID(@IdRes containerID: Int): Boolean {
    return removeFragment(supportFragmentManager.findFragmentById(containerID))
}

fun AppCompatActivity.removeFragment(fragment: Fragment?): Boolean {
    fragment?.let {
        val commit = supportFragmentManager.beginTransaction().remove(fragment).commit()
        return true
    } ?: return false
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun Context.toast(message: String, isLong: Boolean = false) {
    Toast.makeText(this, message, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

inline fun ConstraintLayout.updateParams(constraintSet: ConstraintSet = ConstraintSet(), updates: ConstraintSet.() -> Unit) {
    constraintSet.clone(this)
    constraintSet.updates()
    constraintSet.applyTo(this)
}
