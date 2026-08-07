package com.m57.hermescontrol.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.m57.hermescontrol.R

/**
 * Maple Mono NL（无连字·中文子集化版）— APP 全局字体。
 * GB2312 全量 6763 汉字 + 符号, 日常中文显示不乱码, 中英文 2:1 对齐。
 */
val MapleMonoNL =
    FontFamily(
        Font(R.font.maplemononl_regular, FontWeight.Normal),
        Font(R.font.maplemononl_medium, FontWeight.Medium),
        Font(R.font.maplemononl_semibold, FontWeight.SemiBold),
        Font(R.font.maplemononl_bold, FontWeight.Bold),
    )

/**
 * Full Material 3 type hierarchy — every style explicitly tuned so the
 * app stops inheriting Compose defaults.
 *
 * Letter spacing is tighter than M3 defaults (modern look), line heights are
 * comfortable for long-form.
 */
val Typography =
    Typography(
        // Display — hero numbers, big stats
        displayLarge =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Bold,
                fontSize = 44.sp,
                lineHeight = 52.sp,
                letterSpacing = (-0.5).sp,
            ),
        displayMedium =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                lineHeight = 44.sp,
                letterSpacing = (-0.25).sp,
            ),
        displaySmall =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                lineHeight = 38.sp,
                letterSpacing = 0.sp,
            ),
        // Headline — empty-state titles, screen intros
        headlineLarge =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 34.sp,
                letterSpacing = 0.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 30.sp,
                letterSpacing = 0.sp,
            ),
        headlineSmall =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.1.sp,
            ),
        // Title — TopAppBar, card headings
        titleLarge =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.1.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                letterSpacing = 0.15.sp,
            ),
        titleSmall =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
        // Body — primary reading
        bodyLarge =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.25.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.2.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp,
            ),
        // Label — buttons, chips, captions
        labelLarge =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = MapleMonoNL,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
    )
