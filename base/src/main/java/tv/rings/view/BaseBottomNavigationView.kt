package tv.rings.view

import android.content.Context
import android.support.design.widget.BottomNavigationView
import android.util.AttributeSet

class BaseBottomNavigationView : BottomNavigationView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


}