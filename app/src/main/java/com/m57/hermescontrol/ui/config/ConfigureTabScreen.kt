package com.m57.hermescontrol.ui.config

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.m57.hermescontrol.AlistScreen
import com.m57.hermescontrol.ChatScreen
import com.m57.hermescontrol.ConfigureTabScreen
import com.m57.hermescontrol.DrawerSection
import com.m57.hermescontrol.NavigationController
import com.m57.hermescontrol.R
import com.m57.hermescontrol.ScreenRegistry
import com.m57.hermescontrol.ui.common.HermesScaffold

/** 底部三个主 Tab 对应的页面，功能入口列表里不再重复列出。 */
private val mainTabKeys = setOf(ChatScreen, AlistScreen, ConfigureTabScreen)

/**
 * 配置 Tab —— 功能总入口页。
 *
 * 原侧栏抽屉里的全部功能入口收拢到这里，按分区（对话/自动化/配置/检查）
 * 分组列出，点击进入对应页面。
 */
@Composable
fun ConfigureTabScreenContent() {
    HermesScaffold(
        title = { Text(stringResource(R.string.tab_config)) },
        pinTopBar = true,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            DrawerSection.entries.forEach { section ->
                val items =
                    ScreenRegistry.ALL_SCREENS.filter {
                        it.drawerSection == section && it.key !in mainTabKeys
                    }
                if (items.isEmpty()) return@forEach

                item(key = "header_${section.name}") {
                    Text(
                        text = stringResource(section.titleRes).uppercase(),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                    )
                }
                items(items, key = { it.key.toString() }) { entry ->
                    ListItem(
                        headlineContent = { Text(stringResource(entry.labelRes)) },
                        leadingContent = { Icon(entry.icon, contentDescription = null) },
                        trailingContent = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        },
                        colors = ListItemDefaults.colors(),
                        modifier =
                            Modifier.clickable {
                                NavigationController.navigateTo(entry.key)
                            },
                    )
                }
            }
        }
    }
}
