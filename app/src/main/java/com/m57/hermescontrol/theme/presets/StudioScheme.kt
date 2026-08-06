package com.m57.hermescontrol.theme.presets

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.m57.hermescontrol.theme.HermesStatusColors

/**
 * Studio preset — faithful port of the hermes-web-ui (EKKO Hermes Studio)
 * look: cool light-grey canvas, white side panels, hairline borders,
 * restrained near-monochrome accents with a small green status pop.
 * Small radii (4–8 dp) and low-contrast layering give the "small & refined"
 * feel 师兄 likes.
 */

// ── Light (primary look — Studio is a light UI) ──────────────────────────

private val StudioLightBackground = Color(0xFFF5F6F8)
private val StudioLightOnBackground = Color(0xFF1E293B)
private val StudioLightSurface = Color(0xFFFFFFFF)
private val StudioLightOnSurface = Color(0xFF1E293B)
private val StudioLightSurfaceVariant = Color(0xFFEBEEF5)
private val StudioLightOnSurfaceVariant = Color(0xFF6B7280)
private val StudioLightSurfaceContainerLowest = Color(0xFFFFFFFF)
private val StudioLightSurfaceContainerLow = Color(0xFFFAFAFB)
private val StudioLightSurfaceContainer = Color(0xFFF0F2F5)
private val StudioLightSurfaceContainerHigh = Color(0xFFEBEEF5)
private val StudioLightSurfaceContainerHighest = Color(0xFFE2E5EA)
private val StudioLightPrimary = Color(0xFF1E293B) // send button ink-black
private val StudioLightOnPrimary = Color(0xFFFFFFFF)
private val StudioLightPrimaryContainer = Color(0xFFEBEEF5)
private val StudioLightOnPrimaryContainer = Color(0xFF1E293B)
private val StudioLightSecondary = Color(0xFF6B7280)
private val StudioLightOnSecondary = Color(0xFFFFFFFF)
private val StudioLightSecondaryContainer = Color(0xFFF0F2F5)
private val StudioLightOnSecondaryContainer = Color(0xFF4B5563)
private val StudioLightTertiary = Color(0xFF34C759) // status green pop
private val StudioLightOnTertiary = Color(0xFFFFFFFF)
private val StudioLightTertiaryContainer = Color(0xFFE3F7E9)
private val StudioLightOnTertiaryContainer = Color(0xFF1B8A3A)
private val StudioLightError = Color(0xFFEF5350)
private val StudioLightOnError = Color(0xFFFFFFFF)
private val StudioLightErrorContainer = Color(0xFFFDE3E2)
private val StudioLightOnErrorContainer = Color(0xFFB3261E)
private val StudioLightOutline = Color(0xFFE5E7EB)
private val StudioLightOutlineVariant = Color(0xFFE9EBEF)
private val StudioLightInverseSurface = Color(0xFF1E293B)
private val StudioLightInverseOnSurface = Color(0xFFF5F6F8)

val StudioLightColorScheme =
    lightColorScheme(
        primary = StudioLightPrimary,
        onPrimary = StudioLightOnPrimary,
        primaryContainer = StudioLightPrimaryContainer,
        onPrimaryContainer = StudioLightOnPrimaryContainer,
        inversePrimary = Color(0xFFD4D8DE),
        secondary = StudioLightSecondary,
        onSecondary = StudioLightOnSecondary,
        secondaryContainer = StudioLightSecondaryContainer,
        onSecondaryContainer = StudioLightOnSecondaryContainer,
        tertiary = StudioLightTertiary,
        onTertiary = StudioLightOnTertiary,
        tertiaryContainer = StudioLightTertiaryContainer,
        onTertiaryContainer = StudioLightOnTertiaryContainer,
        background = StudioLightBackground,
        onBackground = StudioLightOnBackground,
        surface = StudioLightSurface,
        onSurface = StudioLightOnSurface,
        surfaceVariant = StudioLightSurfaceVariant,
        onSurfaceVariant = StudioLightOnSurfaceVariant,
        surfaceTint = StudioLightPrimary,
        surfaceContainerLowest = StudioLightSurfaceContainerLowest,
        surfaceContainerLow = StudioLightSurfaceContainerLow,
        surfaceContainer = StudioLightSurfaceContainer,
        surfaceContainerHigh = StudioLightSurfaceContainerHigh,
        surfaceContainerHighest = StudioLightSurfaceContainerHighest,
        inverseSurface = StudioLightInverseSurface,
        inverseOnSurface = StudioLightInverseOnSurface,
        error = StudioLightError,
        onError = StudioLightOnError,
        errorContainer = StudioLightErrorContainer,
        onErrorContainer = StudioLightOnErrorContainer,
        outline = StudioLightOutline,
        outlineVariant = StudioLightOutlineVariant,
        scrim = Color(0xFF000000),
    )

// ── Dark (night companion — same hue family, inverted) ───────────────────

private val StudioDarkBackground = Color(0xFF111318)
private val StudioDarkOnBackground = Color(0xFFE5E7EB)
private val StudioDarkSurface = Color(0xFF171A20)
private val StudioDarkOnSurface = Color(0xFFE5E7EB)
private val StudioDarkSurfaceVariant = Color(0xFF22262E)
private val StudioDarkOnSurfaceVariant = Color(0xFF9CA3AF)
private val StudioDarkSurfaceContainerLowest = Color(0xFF0C0E12)
private val StudioDarkSurfaceContainerLow = Color(0xFF14161B)
private val StudioDarkSurfaceContainer = Color(0xFF1A1D24)
private val StudioDarkSurfaceContainerHigh = Color(0xFF20242C)
private val StudioDarkSurfaceContainerHighest = Color(0xFF282C35)
private val StudioDarkPrimary = Color(0xFFE5E7EB)
private val StudioDarkOnPrimary = Color(0xFF1E293B)
private val StudioDarkPrimaryContainer = Color(0xFF2A2F38)
private val StudioDarkOnPrimaryContainer = Color(0xFFF0F2F5)
private val StudioDarkSecondary = Color(0xFF9CA3AF)
private val StudioDarkOnSecondary = Color(0xFF2A2F38)
private val StudioDarkSecondaryContainer = Color(0xFF2A2F38)
private val StudioDarkOnSecondaryContainer = Color(0xFFC9CDD3)
private val StudioDarkTertiary = Color(0xFF3DDC84)
private val StudioDarkOnTertiary = Color(0xFF0B3D22)
private val StudioDarkTertiaryContainer = Color(0xFF1B3A2A)
private val StudioDarkOnTertiaryContainer = Color(0xFFB8F0CF)
private val StudioDarkError = Color(0xFFEF5350)
private val StudioDarkOnError = Color(0xFFFFFFFF)
private val StudioDarkErrorContainer = Color(0xFF3D1A1A)
private val StudioDarkOnErrorContainer = Color(0xFFFFB4B4)
private val StudioDarkOutline = Color(0xFF2E333C)
private val StudioDarkOutlineVariant = Color(0xFF262B33)
private val StudioDarkInverseSurface = Color(0xFFE5E7EB)
private val StudioDarkInverseOnSurface = Color(0xFF111318)

val StudioDarkColorScheme =
    darkColorScheme(
        primary = StudioDarkPrimary,
        onPrimary = StudioDarkOnPrimary,
        primaryContainer = StudioDarkPrimaryContainer,
        onPrimaryContainer = StudioDarkOnPrimaryContainer,
        inversePrimary = Color(0xFF8A919C),
        secondary = StudioDarkSecondary,
        onSecondary = StudioDarkOnSecondary,
        secondaryContainer = StudioDarkSecondaryContainer,
        onSecondaryContainer = StudioDarkOnSecondaryContainer,
        tertiary = StudioDarkTertiary,
        onTertiary = StudioDarkOnTertiary,
        tertiaryContainer = StudioDarkTertiaryContainer,
        onTertiaryContainer = StudioDarkOnTertiaryContainer,
        background = StudioDarkBackground,
        onBackground = StudioDarkOnBackground,
        surface = StudioDarkSurface,
        onSurface = StudioDarkOnSurface,
        surfaceVariant = StudioDarkSurfaceVariant,
        onSurfaceVariant = StudioDarkOnSurfaceVariant,
        surfaceTint = StudioDarkPrimary,
        surfaceContainerLowest = StudioDarkSurfaceContainerLowest,
        surfaceContainerLow = StudioDarkSurfaceContainerLow,
        surfaceContainer = StudioDarkSurfaceContainer,
        surfaceContainerHigh = StudioDarkSurfaceContainerHigh,
        surfaceContainerHighest = StudioDarkSurfaceContainerHighest,
        inverseSurface = StudioDarkInverseSurface,
        inverseOnSurface = StudioDarkInverseOnSurface,
        error = StudioDarkError,
        onError = StudioDarkOnError,
        errorContainer = StudioDarkErrorContainer,
        onErrorContainer = StudioDarkOnErrorContainer,
        outline = StudioDarkOutline,
        outlineVariant = StudioDarkOutlineVariant,
        scrim = Color(0xFF000000),
    )

// ── Status colors (Studio: green pop, restrained) ────────────────────────

val StudioLightStatusColors =
    HermesStatusColors(
        success = Color(0xFF1B873A),
        successContainer = Color(0xFFD7F5E0),
        onSuccess = Color(0xFFFDFFFD),
        warning = Color(0xFFB45309),
        warningContainer = Color(0xFFFFEAB3),
        onWarning = Color(0xFFFDFFFD),
        error = Color(0xFFB3261E),
        errorContainer = Color(0xFFF9DEDC),
        onError = Color(0xFFFDFFFD),
        info = Color(0xFF2E6FBD),
        infoContainer = Color(0xFFD4E7FF),
        onInfo = Color(0xFFFDFFFD),
    )

val StudioDarkStatusColors =
    HermesStatusColors(
        success = Color(0xFF3DDC84),
        successContainer = Color(0xFF143A23),
        onSuccess = Color(0xFFF5F5F5),
        warning = Color(0xFFFFB627),
        warningContainer = Color(0xFF3D2F0F),
        onWarning = Color(0xFFF5F5F5),
        error = Color(0xFFFF5C5C),
        errorContainer = Color(0xFF3D1414),
        onError = Color(0xFFF5F5F5),
        info = Color(0xFF4DA8FF),
        infoContainer = Color(0xFF0F2A3D),
        onInfo = Color(0xFFF5F5F5),
    )
