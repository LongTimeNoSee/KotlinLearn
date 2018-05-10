package tv.rings.notification

import tv.rings.BaseFragment
import tv.rings.home.HomeFragment
import tv.rings.kotlinloops.app.R

class NotificationFragment : BaseFragment() {
    companion object {
        val TAG = NotificationFragment::class.java.simpleName
        fun newInstance() = NotificationFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_notification
    }

}