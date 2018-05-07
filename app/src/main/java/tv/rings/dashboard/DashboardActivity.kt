package tv.rings.dashboard

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import tv.rings.BaseActivity
import tv.rings.animations.GuestureEvents
import tv.rings.home.HomeFragment
import tv.rings.kotlinloops.app.R
import tv.rings.loadFragment

class DashboardActivity : BaseActivity(), GuestureEvents {
    companion object {
        val TAG = DashboardActivity::class.java.simpleName
    }

    private lateinit var paramsGlHorizontal: ConstraintLayout.LayoutParams
    private lateinit var paramsGlVertical: ConstraintLayout.LayoutParams
    private lateinit var paramsGlBottom: ConstraintLayout.LayoutParams
    private lateinit var paramsGlMarginEnd: ConstraintLayout.LayoutParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)

        paramsGlHorizontal = guidelineHorizontal.layoutParams as ConstraintLayout.LayoutParams
        paramsGlVertical = guidelineVertical.layoutParams as ConstraintLayout.LayoutParams
        paramsGlBottom = guidelineBottom.layoutParams as ConstraintLayout.LayoutParams
        paramsGlMarginEnd = guidelineMarginEnd.layoutParams as ConstraintLayout.LayoutParams

        bottomNavigation.setOnNavigationItemSelectedListener(onItemSelectedListener)

        loadFragment{
            replace(R.id.frmHomeContainer, HomeFragment.newInstance(), HomeFragment.TAG)
        }
    }

    private val onItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.navigation_home -> {
                loadFragment{
                    replace(R.id.frmHomeContainer, HomeFragment.newInstance(), HomeFragment.TAG)
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_trending -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_subscription -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_library -> {

                return@OnNavigationItemSelectedListener true
            }

        }

        false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
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