package com.demo.tictactoe;


import androidx.test.rule.ActivityTestRule;

import com.demo.tictactoe.model.Player;
import com.demo.tictactoe.view.GameMainActivity;

import org.junit.Rule;
import org.junit.Test;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;


public class GameMainActivityUITest {

    @Rule
    public ActivityTestRule<GameMainActivity> activityRule = new ActivityTestRule<>(GameMainActivity.class);

    private Player player1 = new Player("TestUser1", "x");
    private Player player2 = new Player("TestUser2", "o");

    @Test
    public void end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name);
        writeTo(R.id.et_player2, player2.name);
        clickDialogPositiveButton();

        clickOn(R.id.cell_00);
        clickOn(R.id.cell_10);
        clickOn(R.id.cell_01);
        clickOn(R.id.cell_11);
        clickOn(R.id.cell_02);

        assertDisplayed(R.id.tv_winner);
        assertDisplayed(player1.name);
    }
}
