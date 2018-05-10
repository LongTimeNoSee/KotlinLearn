package tv.rings.subscription

import tv.rings.BaseFragment
import tv.rings.home.HomeFragment
import tv.rings.kotlinloops.app.R

class SubscriptionFragment : BaseFragment() {
    companion object {
        val TAG = SubscriptionFragment::class.java.simpleName
        fun newInstance() = SubscriptionFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_subscription
    }

}