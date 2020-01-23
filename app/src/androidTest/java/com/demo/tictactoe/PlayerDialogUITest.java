package com.demo.tictactoe;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import com.demo.tictactoe.view.GameMainActivity;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;

public class PlayerDialogUITest {

    @Rule
    public ActivityTestRule<GameMainActivity> activityRule = new ActivityTestRule<>(GameMainActivity.class);

    @Test
    public void display_empty_names_message_if_names_empty() throws Exception {
        writeTo(R.id.et_player1, "");
        writeTo(R.id.et_player2, "");

        clickDialogPositiveButton();

        assertDisplayed(R.string.game_dialog_empty_name);
    }

    @Test
    public void display_same_names_message_if_names_same() throws Exception {
        writeTo(R.id.et_player1, "TestUser1");
        writeTo(R.id.et_player2, "TestUser1");

        clickDialogPositiveButton();

        assertDisplayed(R.string.game_dialog_same_names);
    }

    @Test
    public void display_empty_name_message_if_one_name_empty() throws Exception {
        writeTo(R.id.et_player1, "");
        writeTo(R.id.et_player2, "TestUser2");

        clickDialogPositiveButton();

        assertDisplayed(R.string.game_dialog_empty_name);
    }

    @Test
    public void close_dialog_after_names_valid() throws Exception {
        writeTo(R.id.et_player1, "Test User 1");
        writeTo(R.id.et_player2, "Test User 2");

        clickDialogPositiveButton();

        assertNotExist(R.id.layout_player1);
    }
}
