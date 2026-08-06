package com.m57.hermescontrol.ui.alist

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.CookieManager
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.m57.hermescontrol.R
import com.m57.hermescontrol.ui.common.HermesScaffold
import com.m57.hermescontrol.ui.common.NavIcon

/** AList 书房 — WebView 套壳，用户在 AList 自己的登录页里登录，凭据不进 App。 */
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun AlistScreen(onOpenDrawer: (() -> Unit)? = null) {
    var isLoading by remember { mutableStateOf(true) }
    var loadError by remember { mutableStateOf<String?>(null) }
    val webViewRef = remember { mutableStateOf<WebView?>(null) }
    var canGoBack by remember { mutableStateOf(false) }

    // 返回键：WebView 有历史就回退，无历史时不拦截（交给导航系统自然返回）
    BackHandler(enabled = canGoBack) {
        webViewRef.value?.goBack()
    }

    // WebView 销毁防泄漏
    DisposableEffect(Unit) {
        onDispose {
            webViewRef.value?.destroy()
        }
    }

    HermesScaffold(
        title = { Text(stringResource(R.string.screen_alist)) },
        navigationIcon = onOpenDrawer?.let { NavIcon.Menu(it) },
    ) { innerPadding ->
        Box(Modifier.fillMaxSize()) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { ctx ->
                    WebView(ctx).apply {
                        webViewRef.value = this
                        settings.javaScriptEnabled = true
                        settings.domStorageEnabled = true
                        settings.loadWithOverviewMode = true
                        settings.useWideViewPort = true
                        CookieManager.getInstance().setAcceptCookie(true)
                        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)

                        webViewClient =
                            object : WebViewClient() {
                                override fun onPageStarted(
                                    view: WebView?,
                                    url: String?,
                                    favicon: Bitmap?,
                                ) {
                                    isLoading = true
                                    loadError = null
                                    canGoBack = view?.canGoBack() == true
                                }

                                override fun onPageFinished(
                                    view: WebView?,
                                    url: String?,
                                ) {
                                    isLoading = false
                                    canGoBack = view?.canGoBack() == true
                                }

                                override fun doUpdateVisitedHistory(
                                    view: WebView?,
                                    url: String?,
                                    isReload: Boolean,
                                ) {
                                    super.doUpdateVisitedHistory(view, url, isReload)
                                    canGoBack = view?.canGoBack() == true
                                }

                                override fun onReceivedError(
                                    view: WebView?,
                                    request: WebResourceRequest?,
                                    error: WebResourceError?,
                                ) {
                                    // 主框架错误才提示（子资源错误忽略）
                                    if (request?.isForMainFrame == true) {
                                        loadError = error?.description?.toString() ?: "加载失败"
                                        isLoading = false
                                    }
                                }

                                override fun onReceivedHttpError(
                                    view: WebView?,
                                    request: WebResourceRequest?,
                                    errorResponse: WebResourceResponse?,
                                ) {
                                    if (request?.isForMainFrame == true) {
                                        loadError = "HTTP ${errorResponse?.statusCode ?: "?"}"
                                        isLoading = false
                                    }
                                }

                                override fun shouldOverrideUrlLoading(
                                    view: WebView?,
                                    request: WebResourceRequest?,
                                ): Boolean = false // 放行 SPA 内部跳转
                            }

                        // 只加载一次，避免 recomposition 重复加载
                        loadUrl("https://study.mgaoxin.com/files/")
                    }
                },
            )

            // 加载指示
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }

            // 错误提示
            loadError?.let { err ->
                Text(
                    text = "无法连接书房: $err",
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    }
}
