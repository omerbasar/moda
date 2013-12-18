package moda.service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import moda.dao.*;
import moda.entity.*;
import org.skife.jdbi.v2.DBI;

import java.util.*;

/**
 * @author omerbasar
 */
public class ModaService {

   private PlayerDAO playerDAO;
   private TeamDAO teamDAO;
   private GameDAO gameDAO;
   private TeamPlayerDAO teamPlayerDAO;
   private PlayerStatDAO playerStatDAO;

   private Map<String, Player> playerMapByName;

   public ModaService(){
      MysqlDataSource ds = new MysqlDataSource();
      ds.setUser("root");
      ds.setPassword("");
      ds.setServerName("127.0.0.1");
      ds.setDatabaseName("moda");
      DBI dbi = new DBI(ds);
      playerDAO = dbi.open(PlayerDAO.class);
      teamDAO = dbi.open(TeamDAO.class);
      gameDAO = dbi.open(GameDAO.class);
      teamPlayerDAO = dbi.open(TeamPlayerDAO.class);
      playerStatDAO = dbi.open(PlayerStatDAO.class);

      playerMapByName = getPlayerMapByName();

   }

   public void deleteAll(){
      teamDAO.deleteAll();
      gameDAO.deleteAll();
      teamPlayerDAO.deleteAll();
      playerStatDAO.deleteAll();
   }

   public Map<String, Player> getPlayerMapByName(){
      Map<String, Player> map = new HashMap<String, Player>();
      for (Player player : playerDAO.getPlayers()) {
         map.put(player.getName(), player);
      }
      return map;
   }

   public Team createTeam(Integer score, Integer point, Map<String, Integer> playerNameScoreMap){
      Integer rating = 0;
      for (String playerName : playerNameScoreMap.keySet()) {
         Player player = playerMapByName.get(playerName);
         if(player == null){
            throw new RuntimeException("player with name: " + playerName + " is not found in db");
         }
         rating += player.getRating();
      }
      Team team = new Team();
      team.setScore(score);
      team.setPoint(point);
      team.setRating(rating);
      Integer id = teamDAO.insert(team);
      team.setId(id);
      return team;
   }

   private Integer getScore(Map<String, Integer> playerNameScoreMap){
      Integer total = 0;
      for (Integer score : playerNameScoreMap.values()) {
         total += score;
      }

      return total;
   }

   public Game insertGame(Date playedTime, Map<String, Integer> homeTeamScoreMap, Map<String, Integer> awayTeamScoreMap){
      Integer homeScore = getScore(homeTeamScoreMap);
      Integer awayScore = getScore(awayTeamScoreMap);
      Integer homePoint = (homeScore > awayScore) ? 3 : ((homeScore.equals(awayScore) ? 1 : 0));
      Integer awayPoint = (awayScore > homeScore) ? 3 : ((homeScore.equals(awayScore) ? 1 : 0));

      Team homeTeam = createTeam(homeScore, homePoint, homeTeamScoreMap);
      Team awayTeam = createTeam(awayScore, awayPoint, awayTeamScoreMap);

      insertTeamPlayers(homeTeamScoreMap, homeTeam, homePoint);
      insertTeamPlayers(awayTeamScoreMap, awayTeam, awayPoint);

      Game game = new Game();
      game.setHomeTeamId(homeTeam.getId());
      game.setAwayTeamId(awayTeam.getId());
      game.setPlayedTime(playedTime);

      gameDAO.insert(game);

      return null;
   }

   private void insertTeamPlayers(Map<String, Integer> scoreMap, Team team, Integer point) {
      for (String name : scoreMap.keySet()) {
         Player player = playerMapByName.get(name);
         TeamPlayer teamPlayer = new TeamPlayer();
         teamPlayer.setTeamId(team.getId());
         teamPlayer.setPlayerId(player.getId());
         teamPlayer.setScore(scoreMap.get(name));
         teamPlayer.setPoint(point);
         teamPlayerDAO.insert(teamPlayer);
      }
   }

   public void calculateStatsAccordingTo(int referencePlayerId) {
      Map<Integer, PlayerStat> mapWithPlayer = new HashMap<Integer, PlayerStat>();
      Map<Integer, PlayerStat> mapWithoutPlayer = new HashMap<Integer, PlayerStat>();

      List<Game> games = gameDAO.selectAll();
      for (Game game : games) {
         List<TeamPlayer> homeTeamPlayers = teamPlayerDAO.select(game.getHomeTeamId());
         // player id homeTeam'de
         if(contains(homeTeamPlayers, referencePlayerId)){
            for (TeamPlayer teamPlayer : homeTeamPlayers) {
               Integer playerId = teamPlayer.getPlayerId();
               PlayerStat playerStat = mapWithPlayer.get(playerId);
               playerStat = add(playerStat, PlayerStat.newInstance(1, playerId, 1, teamPlayer.getScore(), teamPlayer.getPoint()));
               mapWithPlayer.put(playerId, playerStat);
            }
         }else{
            for (TeamPlayer teamPlayer : homeTeamPlayers) {
               Integer playerId = teamPlayer.getPlayerId();
               PlayerStat playerStat = mapWithoutPlayer.get(playerId);
               playerStat = add(playerStat, PlayerStat.newInstance(2, playerId, 1, teamPlayer.getScore(), teamPlayer.getPoint()));
               mapWithoutPlayer.put(playerId, playerStat);
            }
         }

         List<TeamPlayer> awayTeamPlayers = teamPlayerDAO.select(game.getAwayTeamId());
         // player id homeTeam'de
         if(contains(awayTeamPlayers, referencePlayerId)){
            for (TeamPlayer teamPlayer : awayTeamPlayers) {
               Integer playerId = teamPlayer.getPlayerId();
               PlayerStat playerStat = mapWithPlayer.get(playerId);
               playerStat = add(playerStat, PlayerStat.newInstance(1, playerId, 1, teamPlayer.getScore(), teamPlayer.getPoint()));
               mapWithPlayer.put(playerId, playerStat);
            }
         }else{
            for (TeamPlayer teamPlayer : awayTeamPlayers) {
               Integer playerId = teamPlayer.getPlayerId();
               PlayerStat playerStat = mapWithoutPlayer.get(playerId);
               playerStat = add(playerStat, PlayerStat.newInstance(2, playerId, 1, teamPlayer.getScore(), teamPlayer.getPoint()));
               mapWithoutPlayer.put(playerId, playerStat);
            }
         }
      }

      System.out.println("mapWithPlayer = " + mapWithPlayer.values());
      System.out.println("mapWithoutPlayer = " + mapWithoutPlayer.values());

      for (PlayerStat playerStat : mapWithoutPlayer.values()) {
         playerStatDAO.insert(playerStat);
      }
      for (PlayerStat playerStat : mapWithPlayer.values()) {
         playerStatDAO.insert(playerStat);
      }
   }

   public Boolean contains(List<TeamPlayer> teamPlayers, Integer playerId){
      for (TeamPlayer teamPlayer : teamPlayers) {
         if(teamPlayer.getPlayerId().equals(playerId)){
            return true;
         }
      }
      return false;
   }

   public PlayerStat add(PlayerStat playerStat, PlayerStat added){
      if(playerStat == null){
         playerStat = added;
      }else{
         playerStat.setPlayed(playerStat.getPlayed() + added.getPlayed());
         playerStat.setPoint(playerStat.getPoint() + added.getPoint());
         playerStat.setScore(playerStat.getScore() + added.getScore());
      }
      return playerStat;
   }
}
