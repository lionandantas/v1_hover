
package br.com.hover.menu;
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.hover.R
import br.com.hover.hover.Content


class NonFullscreenContent(context: Context): Content {
    private var mContext:Context? = null
    private var mContent:View?= null

    init{
        mContext = context.getApplicationContext()
    }

    override fun onShown() {

    }

    override fun getView(): View {
        if (null == mContent) {
            mContent = LayoutInflater.from(mContext).inflate(R.layout.content_non_fullscreen, null)
            mContent?.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        return mContent!!
    }

    override fun onHidden() {

    }

    override fun isFullscreen(): Boolean {
        return false
    }
}