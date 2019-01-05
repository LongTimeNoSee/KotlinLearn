package tv.rings

import android.app.Application

class PlayerApp : BaseApp() {
    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}