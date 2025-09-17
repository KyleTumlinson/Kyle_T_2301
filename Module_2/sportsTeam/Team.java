/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */
package Module_2.sportsTeam;

public class Team {
    private String teamName; // the team name
    private String[] players = new String[20]; // the players
    private int playerCount = 0; // the number of players.

    // constructor for Team accepting an argument for the team name
    Team(String teamName)
    {
        this.teamName = teamName;
    }

    // public function to add a player to the team accepting the player name
    public void AddPlayer(String playerName)
    {
        players[playerCount] = new String(playerName);
        playerCount++;
    }

    // getter for the player string array
    public String[] getPlayers()
    {
        return players;
    }

    // getter for the playerCount
    public int getPlayerCount()
    {
        return playerCount;
    }

    // getter for the team name
    public String getTeamName()
    {
        return teamName;
    }
}
