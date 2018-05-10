package tv.rings.library

import tv.rings.BaseFragment
import tv.rings.home.HomeFragment
import tv.rings.kotlinloops.app.R

class LibraryFragment : BaseFragment() {
    companion object {
        val TAG = LibraryFragment::class.java.simpleName
        fun newInstance() = LibraryFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_library
    }

}