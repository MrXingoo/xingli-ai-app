package com.m57.hermescontrol

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.m57.hermescontrol.data.local.AuthManager
import com.m57.hermescontrol.ui.config.ConfigureTabScreenContent
import com.m57.hermescontrol.ui.settings.SettingsAboutPage
import com.m57.hermescontrol.ui.settings.SettingsAppearancePage
import com.m57.hermescontrol.ui.settings.SettingsBehaviorPage
import com.m57.hermescontrol.ui.settings.SettingsChatPage
import com.m57.hermescontrol.ui.settings.SettingsConnectionPage
import com.m57.hermescontrol.ui.settings.SettingsViewModel
import com.m57.hermescontrol.ui.authlogin.AuthLoginScreen as AuthLoginScreenContent
import com.m57.hermescontrol.ui.landing.LandingScreen as LandingScreenContent

/** 底部主 Tab 定义：会话 / 书房 / 配置。 */
private enum class MainTab(
    val key: NavKey,
    @param:StringRes val labelRes: Int,
    val icon: ImageVector,
) {
    CHAT(ChatScreen, R.string.tab_chat, Icons.AutoMirrored.Filled.Chat),
    ALIST(AlistScreen, R.string.screen_alist, Icons.Filled.Folder),
    CONFIG(ConfigureTabScreen, R.string.tab_config, Icons.Filled.Settings),
}

private val mainTabKeys = MainTab.entries.map { it.key }.toSet()

private fun appEntryProvider(
    sessionId: String?,
    openDrawer: () -> Unit,
) = entryProvider {
    entry<LandingScreen> {
        // B7 (Jun 30 2026, kanban t_424): route landing screen buttons through navigateTo to prevent duplicate screens
        LandingScreenContent(
            onAuthLogin = {
                NavigationController.navigateTo(AuthLoginScreen)
            },
        )
    }

    entry<AuthLoginScreen> {
        AuthLoginScreenContent(
            onConnected = {
                NavigationController.resetTo(ChatScreen)
            },
            onBack = {
                NavigationController.goBack()
            },
        )
    }

    entry<ConfigureTabScreen> {
        ConfigureTabScreenContent()
    }

    ScreenRegistry.ALL_SCREENS.forEach { screen ->
        addEntryProvider(clazz = screen.key::class) {
            screen.content(sessionId, openDrawer)
        }
    }

    // ── Settings drill-down sub-pages ───────────────────────────────────
    entry<SettingsConnection> {
        SettingsConnectionPage(
            onBack = { NavigationController.goBack() },
            onLogout = { /* handled by caller via goBack fallback */ },
            viewModel = viewModel { SettingsViewModel() },
        )
    }
    entry<SettingsAppearance> {
        SettingsAppearancePage(
            onBack = { NavigationController.goBack() },
            viewModel = viewModel { SettingsViewModel() },
        )
    }
    entry<SettingsChat> {
        SettingsChatPage(
            onBack = { NavigationController.goBack() },
            viewModel = viewModel { SettingsViewModel() },
        )
    }
    entry<SettingsBehavior> {
        SettingsBehaviorPage(
            onBack = { NavigationController.goBack() },
            viewModel = viewModel { SettingsViewModel() },
        )
    }
    entry<SettingsAbout> {
        SettingsAboutPage(
            onBack = { NavigationController.goBack() },
            viewModel = viewModel { SettingsViewModel() },
        )
    }
}

@Composable
fun MainNavigation(sessionId: String? = null) {
    val token by AuthManager.tokenFlow.collectAsState()
    val hasToken = !token.isNullOrBlank()
    val startScreen: NavKey = if (hasToken) ChatScreen else LandingScreen

    val backStack = remember(startScreen) { NavBackStack(startScreen) }
    NavigationController.backStack = backStack

    val currentScreen = backStack.lastOrNull() ?: startScreen

    // 底部 Tab 高亮：跟随当前页面；在子页面时保持最近一次的主 Tab。
    val currentTabKey = backStack.lastOrNull { it in mainTabKeys } ?: startScreen

    // ☰ 图标统一跳转到「配置」Tab —— 全部功能入口都收拢在那里。
    // 用 navigateToTab：从子页面点 ☰ 会 pop 回配置页而不是叠一层。
    val openDrawer: () -> Unit = { NavigationController.navigateToTab(ConfigureTabScreen) }

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars,
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                MainTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = currentTabKey == tab.key,
                        onClick = { NavigationController.navigateToTab(tab.key) },
                        icon = { Icon(tab.icon, contentDescription = null) },
                        label = { Text(stringResource(tab.labelRes)) },
                    )
                }
            }
        },
    ) { paddingValues ->
        NavDisplay(
            backStack = backStack,
            onBack = { NavigationController.goBack() },
            entryProvider =
                appEntryProvider(sessionId, openDrawer),
            modifier =
                Modifier
                    .padding(paddingValues)
                    .consumeWindowInsets(paddingValues)
                    .fillMaxSize(),
        )
    }
}
