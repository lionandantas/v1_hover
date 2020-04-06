
package br.com.hover.menu;
import android.content.Context
import android.view.View
import br.com.hover.R

import br.com.hover.hover.HoverMenu

import java.util.*

class V1HoverMenu(context:Context, menuId:String) : HoverMenu(){

    private val mContext: Context = context.applicationContext
    private val mMenuId:String = menuId
    private val mSection:Section
    init{
        mSection = Section(
            SectionId("0"),
            createTabView(),
            NonFullscreenContent(context)
        )
    }

    private fun createTabView(): View {
        val resources = mContext.resources
        val view = V1TabView(
            mContext,
            resources.getDrawable(R.drawable.tab_background),
            resources.getDrawable(R.drawable.ic_orange_circle)
        )

        //backgroundDrawable
        //.view.setBackgroundDrawable(resources.getDrawable(R.drawable.theo))
       // view.setTabBackgroundColor( resources.getColor(R.color.colorAccent))
          //view.setTabForegroundColor(resources.getColor(R.color.colorPrimaryDark))
        return view
    }
    override fun getSections(): MutableList<Section> {
        return Collections.singletonList(mSection)
    }

    override fun getId(): String {
        return mMenuId
    }

    override fun getSection(index: Int): Section? {
        return mSection
    }

    override fun getSection(sectionId: SectionId): Section? {
       return mSection
    }

    override fun getSectionCount(): Int {
        return 1
    }

}