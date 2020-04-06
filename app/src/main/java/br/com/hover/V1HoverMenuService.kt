
package br.com.hover;
import android.content.Context
import android.content.Intent
import android.view.ContextThemeWrapper
import androidx.annotation.NonNull
import br.com.hover.R

import br.com.hover.hover.HoverMenu
import br.com.hover.hover.HoverView
import br.com.hover.hover.window.HoverMenuService
import br.com.hover.menu.V1HoverMenu


open class V1HoverMenuService : HoverMenuService() {

    protected fun contextForHoverMenu(): Context {
        return ContextThemeWrapper(this, R.style.AppTheme)
    }

    /*protected val contextForHoverMenu: Context
        get() {
            return ContextThemeWrapper(this, R.style.AppTheme)
        }*/
    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected override fun onHoverMenuLaunched(intent: Intent,hoverView: HoverView) {
        hoverView.setMenu(createHoverMenu())
        hoverView.collapse()
    }


    private fun createHoverMenu(): HoverMenu {
        return V1HoverMenu(applicationContext, "nonfullscreen")//DemoHoverMenu(getApplicationContext(), "nonfullscreen")
    }

    companion object {
        private val TAG = "V1HoverMenuService"
        fun showFloatingMenu(context: Context) {
            context.startService(Intent(context, V1HoverMenuService::class.java))
        }
    }
}