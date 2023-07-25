package org.reactormonk.robolectricnorecompose

import android.content.Context
import androidx.test.annotation.ExperimentalTestApi
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

import androidx.compose.ui.test.junit4.createComposeRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33], manifest=Config.NONE)
class ExampleUnitTest {
    @OptIn(androidx.compose.ui.test.ExperimentalTestApi::class)
    @get:Rule
    val composeTestRule = createComposeRule(CoroutineName("Test") + Dispatchers.IO)

    @Before
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun noRecompose() {
        composeTestRule.setContent {
            BugTesting()
        }
        runBlocking {
            delay(1500)
        }
    }
}