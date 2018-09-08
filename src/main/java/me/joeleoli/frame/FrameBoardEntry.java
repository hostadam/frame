package me.joeleoli.frame;

import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class FrameBoardEntry {

	private final FrameBoard board;
	@Setter
	private String text;
	private String identifier;
	private Team team;

	public FrameBoardEntry(FrameBoard board, String text) {
		this.board = board;
		this.text = text;
		this.identifier = this.board.getUniqueIdentifier(text);

		this.setup();
	}

	public void setup() {
		final Scoreboard scoreboard = this.board.getScoreboard();
		String teamName = this.identifier;

		// This shouldn't happen, but just in case
		if (teamName.length() > 16) {
			teamName = teamName.substring(0, 16);
		}

		Team team = scoreboard.getTeam(teamName);

		// Register the team if it does not exist
		if (team == null) {
			team = scoreboard.registerNewTeam(teamName);
		}

		// Add the entry to the team
		if (!team.getEntries().contains(this.identifier)) {
			team.addEntry(this.identifier);
		}

		// Add the entry if it does not exist
		if (!this.board.getEntries().contains(this)) {
			this.board.getEntries().add(this);
		}

		this.team = team;
	}

	public void send(int position) {
		if (this.text.length() > 16) {
			String prefix = this.text.substring(0, 16);
			String suffix;

			if (prefix.endsWith(ChatColor.COLOR_CHAR + "")) {
				prefix = prefix.substring(0, 15);
				suffix = ChatColor.COLOR_CHAR + this.text.substring(17, this.text.length());
			} else {
				if (prefix.charAt(14) == ChatColor.COLOR_CHAR) {
					suffix = prefix.substring(14, 16) + this.text.substring(18, this.text.length());
					prefix = prefix.substring(0, 14);
				} else {
					suffix = this.text.substring(16, this.text.length());
				}
			}

			if (suffix.length() > 16) {
				suffix = suffix.substring(0, 16);
			}

			this.team.setPrefix(prefix);
			this.team.setSuffix(suffix);
		} else {
			this.team.setPrefix(this.text);
			this.team.setSuffix("");
		}

		Score score = this.board.getObjective().getScore(this.identifier);
		score.setScore(position);
	}

	public void remove() {
		this.board.getIdentifiers().remove(this.identifier);
		this.board.getScoreboard().resetScores(this.identifier);
	}

}
