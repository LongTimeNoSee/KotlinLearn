package tv.rings.home

import android.os.Bundle
import tv.rings.BaseFragment
import tv.rings.kotlinloops.app.R

class HomeFragment : BaseFragment() {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
        fun newInstance() = HomeFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}