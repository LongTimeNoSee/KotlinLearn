package tv.rings.dashboard

import android.os.Bundle
import android.view.View
import tv.rings.BaseActivity
import tv.rings.animations.GuestureEvents
import tv.rings.kotlinloops.app.R

class DashboardActivity : BaseActivity(), GuestureEvents {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }


    override fun onDismiss(view: View) {

    }

    override fun onScale(percentage: Float) {
    }

    override fun onSwipe(percentage: Float) {
    }

    override fun onExpand(isExpanded: Boolean) {
    }

    override fun onClick(view: View) {

    }

}