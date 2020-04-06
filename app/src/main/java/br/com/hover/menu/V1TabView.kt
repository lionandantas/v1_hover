package br.com.hover.menu;

import android.content.Context
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorInt
import kotlin.math.roundToInt

class V1TabView (context: Context, backgroundDrawable: Drawable, iconDrawable:Drawable):View(context) {
    private var mBackgroundColor:Int = 0
    private var mForegroundColor:Int= 0
    private var mCircleDrawable:Drawable
    private var mIconDrawable:Drawable
    private var mIconInsetLeft:Float = 0F
    private var mIconInsetTop:Float = 0F
    private var mIconInsetRight:Float = 0F
    private var mIconInsetBottom:Float = 0F
    init{
        mCircleDrawable = backgroundDrawable
        mIconDrawable = iconDrawable
        init()
    }
    private fun init() {
        val insetsDp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10F, context.resources.displayMetrics)
        mIconInsetBottom = insetsDp
        mIconInsetRight = mIconInsetBottom
        mIconInsetTop = mIconInsetRight
        mIconInsetLeft = mIconInsetTop
    }
    fun setTabBackgroundColor(@ColorInt backgroundColor:Int) {
        mBackgroundColor = backgroundColor
        mCircleDrawable.setColorFilter(mBackgroundColor, PorterDuff.Mode.SRC_ATOP)
    }
    fun setTabForegroundColor(@ColorInt foregroundColor:Int) {
        mForegroundColor = foregroundColor
        if (null != mForegroundColor)
        {
            mIconDrawable.setColorFilter(mForegroundColor, PorterDuff.Mode.SRC_ATOP)
        }
        else
        {
            mIconDrawable.setColorFilter(null)
        }
    }
    fun setIcon(icon:Drawable) {
        mIconDrawable = icon
        if (null != mForegroundColor && null != mIconDrawable)
        {
            mIconDrawable.setColorFilter(mForegroundColor, PorterDuff.Mode.SRC_ATOP)
        }
        updateIconBounds()
        invalidate()
    }
    protected override fun onSizeChanged(w:Int, h:Int, oldw:Int, oldh:Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // Make circle as large as View minus padding.
        mCircleDrawable.setBounds(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom())
        // Re-size the icon as necessary.
        updateIconBounds()
        invalidate()
    }
    private fun updateIconBounds() {
        if (null != mIconDrawable)
        {
            val bounds = Rect(mCircleDrawable.getBounds())
            bounds.set((bounds.left + mIconInsetLeft).toInt(),
                (bounds.top + mIconInsetTop).toInt(),
                (bounds.right - mIconInsetRight).toInt(), (bounds.bottom - mIconInsetBottom).roundToInt()
            )
            mIconDrawable.setBounds(bounds)
        }
    }
    protected override fun onDraw(canvas: Canvas) {
        mCircleDrawable.draw(canvas)
        if (null != mIconDrawable)
        {
            mIconDrawable.draw(canvas)
        }
    }
}