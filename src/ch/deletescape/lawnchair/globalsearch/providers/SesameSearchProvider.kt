package ch.deletescape.lawnchair.globalsearch.providers

import android.content.*
import android.graphics.drawable.Drawable
import android.support.annotation.Keep
import ch.deletescape.lawnchair.colors.ColorEngine
import ch.deletescape.lawnchair.globalsearch.SearchProvider
import com.android.launcher3.R
import com.android.launcher3.util.PackageManagerHelper

class SesameSearchProvider(context: Context) : SearchProvider(context) {

    private val PACKAGE = "ninja.sesame.app.edge"

    override val name = context.getString(R.string.search_provider_sesame)!!
    override val supportsVoiceSearch: Boolean
        get() = false
    override val supportsAssistant: Boolean
        get() = false

    override val isAvailable: Boolean
        get() = PackageManagerHelper.isAppEnabled(context.packageManager, PACKAGE, 0)

    override fun startSearch(callback: (intent: Intent) -> Unit) = callback(Intent("ninja.sesame.app.action.OPEN_SEARCH").setPackage(PACKAGE))

    override fun getIcon(): Drawable = context.getDrawable(R.drawable.ic_sesame)!!.mutate().apply {
             setTint(ColorEngine.getInstance(context).accent)
         }

}