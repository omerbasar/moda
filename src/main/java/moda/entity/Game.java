package moda.entity;

import java.util.Date;

/**
 * @author omerbasar
 */
public class Game {

   private Integer id;
   private Date playedTime;
   private Integer homeTeamId;
   private Integer awayTeamId;
   private Double homeTeamCoef;
   private Double awayTeamCoef;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Date getPlayedTime() {
      return playedTime;
   }

   public void setPlayedTime(Date playedTime) {
      this.playedTime = playedTime;
   }

   public Integer getHomeTeamId() {
      return homeTeamId;
   }

   public void setHomeTeamId(Integer homeTeamId) {
      this.homeTeamId = homeTeamId;
   }

   public Integer getAwayTeamId() {
      return awayTeamId;
   }

   public void setAwayTeamId(Integer awayTeamId) {
      this.awayTeamId = awayTeamId;
   }

   public Double getHomeTeamCoef() {
      return homeTeamCoef;
   }

   public void setHomeTeamCoef(Double homeTeamCoef) {
      this.homeTeamCoef = homeTeamCoef;
   }

   public Double getAwayTeamCoef() {
      return awayTeamCoef;
   }

   public void setAwayTeamCoef(Double awayTeamCoef) {
      this.awayTeamCoef = awayTeamCoef;
   }

   public static Game newInstance(Integer id, Date playedTime, Integer homeTeamId, Integer awayTeamId, Double homeTeamCoef, Double awayTeamCoef){
      Game game = new Game();
      game.setId(id);
      game.setPlayedTime(playedTime);
      game.setHomeTeamId(homeTeamId);
      game.setAwayTeamId(awayTeamId);
      game.setHomeTeamCoef(homeTeamCoef);
      game.setAwayTeamCoef(awayTeamCoef);
      return game;
   }
}
