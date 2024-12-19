package ru.timestop.clicker.score.adapter.input;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.timestop.clicker.score.core.model.LeaderBoard;
import ru.timestop.clicker.score.core.model.Score;
import ru.timestop.clicker.score.core.model.TotalScore;
import ru.timestop.clicker.score.core.port.input.ScoreService;

/**
 * @author t.i.m.e.s.t.o.p@mail.ru
 */
@RestController
@CrossOrigin
public class UserScoreController {
    private final ScoreService scoreService;

    public UserScoreController(@Autowired ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @Operation(summary = "Store the score of an user.")
    @PutMapping(value = "/score")
    @ResponseStatus(HttpStatus.OK)
    public void createScore(
            @Parameter(description = "The score of an user.", required = true)
            @Valid
            @RequestBody
            @Nonnull Score score) {
        this.scoreService.createScore(score);
    }

    @Operation(summary = "Store the score of an user.")
    @PostMapping(value = "/score")
    @ResponseStatus(HttpStatus.OK)
    public void updateScore(
            @Parameter(description = "The score of an user.", required = true)
            @Valid
            @RequestBody
            @Nonnull Score score) {
        this.scoreService.updateScore(score);
    }

    @Operation(summary = "The total score of all users.")
    @GetMapping(value = "/score/total")
    @ResponseStatus(HttpStatus.OK)
    public TotalScore getTotalScore() {
        return this.scoreService.getTotalScore();
    }

    @Operation(summary = "Top 100 users.")
    @GetMapping(value = "/leaderboard")
    @ResponseStatus(HttpStatus.OK)
    public LeaderBoard getLeaderBoard() {
        return this.scoreService.getLeaderboard();
    }
}
