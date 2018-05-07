package tv.rings

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {
    abstract fun getLayoutId() : Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getLayoutId() == 0) {
            throw RuntimeException("Invalid Layout ID")
        }
        return inflater?.inflate(getLayoutId(), container, false)
    }

    fun enableFullScreen(isEnable: Boolean) {
        if (isEnable) {
            activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        } else {
            activity?.window?.decorView?.systemUiVisibility = View.VISIBLE
        }
    }
}