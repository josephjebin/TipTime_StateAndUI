package com.example.tiptime

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeScreen()
            }
        }

        composeTestRule.onNodeWithText(R.string.bill_amount.toString()).performTextInput("10")
        composeTestRule.onNodeWithText(R.string.tip_pct.toString()).performTextInput("20")
        composeTestRule.onNodeWithText(R.string.tip_amount.toString() + "$2.00").assertExists()
    }
}