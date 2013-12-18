package moda.entity;

/**
 * @author omerbasar
 */
public class TeamPlayer {

   private Integer playerId;
   private Integer teamId;
   private Integer score;
   private Integer point;

   public Integer getPlayerId() {
      return playerId;
   }

   public void setPlayerId(Integer playerId) {
      this.playerId = playerId;
   }

   public Integer getTeamId() {
      return teamId;
   }

   public void setTeamId(Integer teamId) {
      this.teamId = teamId;
   }

   public Integer getScore() {
      return score;
   }

   public void setScore(Integer score) {
      this.score = score;
   }

   public Integer getPoint() {
      return point;
   }

   public void setPoint(Integer point) {
      this.point = point;
   }

   public static TeamPlayer newInstance(Integer playerId, Integer teamId, Integer score, Integer point){
      TeamPlayer teamPlayer = new TeamPlayer();
      teamPlayer.setPlayerId(playerId);
      teamPlayer.setTeamId(teamId);
      teamPlayer.setScore(score);
      teamPlayer.setPoint(point);
      return teamPlayer;
   }
}
