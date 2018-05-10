package tv.rings.trending

import tv.rings.BaseFragment
import tv.rings.home.HomeFragment
import tv.rings.kotlinloops.app.R

class TrendingFragment : BaseFragment() {
    companion object {
        val TAG = TrendingFragment::class.java.simpleName
        fun newInstance() = TrendingFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_trending
    }

}