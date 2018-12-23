package tv.rings.extensions

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty

object DelegatesExt {
    fun <T> preference(context: Context, name: String, default: T)
            = Preference(context, name, default)
}

class Preference<T>(private val context: Context, private val name: String,
                    private val default: T) {
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = findPreference(name, default)

    private fun findPreference(name: String, default: T): T = with(prefs) {
        val res: Any = when(default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalAccessException("can not operation")
        }

        res as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = with(prefs.edit()) {
        when(value) {
            is Long -> putLong(name, value)
            is Int -> putInt(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalAccessException("can not operation set")
        }
    }

}