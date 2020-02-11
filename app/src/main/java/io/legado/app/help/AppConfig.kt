package io.legado.app.help

import io.legado.app.App
import io.legado.app.R
import io.legado.app.constant.PreferKey
import io.legado.app.utils.*

object AppConfig {

    var isNightTheme: Boolean
        get() {
            return when (App.INSTANCE.getPrefString(PreferKey.themeMode, "0")) {
                "1" -> false
                "2" -> true
                else -> App.INSTANCE.sysIsDarkMode()
            }
        }
        set(value) {
            if (value) {
                App.INSTANCE.putPrefString(PreferKey.themeMode, "2")
            } else {
                App.INSTANCE.putPrefString(PreferKey.themeMode, "1")
            }
        }

    var isTransparentStatusBar: Boolean
        get() = App.INSTANCE.getPrefBoolean("transparentStatusBar")
        set(value) {
            App.INSTANCE.putPrefBoolean("transparentStatusBar", value)
        }

    var backupPath: String?
        get() = App.INSTANCE.getPrefString(PreferKey.backupPath)
        set(value) {
            if (value.isNullOrEmpty()) {
                App.INSTANCE.removePref(PreferKey.backupPath)
            } else {
                App.INSTANCE.putPrefString(PreferKey.backupPath, value)
            }
        }

    var isShowRSS: Boolean
        get() = App.INSTANCE.getPrefBoolean(PreferKey.showRss, true)
        set(value) {
            App.INSTANCE.putPrefBoolean(PreferKey.showRss, value)
        }

    val autoRefreshBook: Boolean
        get() = App.INSTANCE.getPrefBoolean(App.INSTANCE.getString(R.string.pk_auto_refresh))

    var threadCount: Int
        get() = App.INSTANCE.getPrefInt(PreferKey.threadCount, 16)
        set(value) {
            App.INSTANCE.putPrefInt(PreferKey.threadCount, value)
        }

    var importBookPath: String?
        get() = App.INSTANCE.getPrefString("importBookPath")
        set(value) {
            if (value == null) {
                App.INSTANCE.removePref("importBookPath")
            } else {
                App.INSTANCE.putPrefString("importBookPath", value)
            }
        }

    var ttsSpeechRate: Int
        get() = App.INSTANCE.getPrefInt(PreferKey.ttsSpeechRate, 5)
        set(value) {
            App.INSTANCE.putPrefInt(PreferKey.ttsSpeechRate, value)
        }

    val ttsSpeechPer: String
        get() = App.INSTANCE.getPrefString(PreferKey.ttsSpeechPer) ?: "0"

    val isEInkMode: Boolean
        get() = App.INSTANCE.getPrefBoolean("isEInkMode")

    val clickAllNext: Boolean get() = App.INSTANCE.getPrefBoolean(PreferKey.clickAllNext, false)

    val isChineseConverterEnable: String?
        get() = App.INSTANCE.getPrefString(PreferKey.isChineseConverterEnable)
}
