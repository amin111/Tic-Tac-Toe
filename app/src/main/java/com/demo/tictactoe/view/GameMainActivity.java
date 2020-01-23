package com.demo.tictactoe.view;


import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.demo.tictactoe.R;
import com.demo.tictactoe.model.Player;
import com.demo.tictactoe.viewmodel.GameViewModel;
import com.demo.tictactoe.databinding.ActivityGameMainBinding;

import static com.demo.tictactoe.utilities.StringUtility.isNullOrEmpty;

public class GameMainActivity extends AppCompatActivity {

    private static final String GAME_PLAYER_DIALOG_TAG = "game_player_dialog_tag";
    private static final String GAME_WINNER_DIALOG_TAG = "game_winner_dialog_tag";
    private static final String NO_WINNER = "No one";
    private GameViewModel gameViewModel;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        promptForPlayers();
    }

    public void promptForPlayers() {
        PlayerDialog dialog = PlayerDialog.newInstance(this);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), GAME_PLAYER_DIALOG_TAG);
    }

    public void onPlayersSet(String player1, String player2) {
        initDataBinding(player1, player2);
    }

    private void initDataBinding(String player1, String player2) {
        ActivityGameMainBinding activityGameMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_main);
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.init(player1, player2);
        activityGameMainBinding.setGameViewModel(gameViewModel);
        setUpOnGameEndListener();
    }

    private void setUpOnGameEndListener() {
        gameViewModel.getWinner().observe(this, this::onGameWinnerChanged);
    }

    @VisibleForTesting
    public void onGameWinnerChanged(Player winner) {
        String winnerName = winner == null || isNullOrEmpty(winner.name) ? NO_WINNER : winner.name;
        WinnerDialog dialog = WinnerDialog.newInstance(this, winnerName);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(), GAME_WINNER_DIALOG_TAG);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            super.onBackPressed();
        else {
            if (back_pressed + 2000 > System.currentTimeMillis())
                super.onBackPressed();
            else
                Toast.makeText(getBaseContext(), R.string.exit_note, Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }
}
