package moda.entity;

/**
 * @author omerbasar
 */
public class PlayerStat {

   private Integer id;
   private Integer playerId;
   private Integer played;
   private Integer point;
   private Double score;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getPlayerId() {
      return playerId;
   }

   public void setPlayerId(Integer playerId) {
      this.playerId = playerId;
   }

   public Integer getPlayed() {
      return played;
   }

   public void setPlayed(Integer played) {
      this.played = played;
   }

   public Integer getPoint() {
      return point;
   }

   public void setPoint(Integer point) {
      this.point = point;
   }

   public Double getScore() {
      return score;
   }

   public void setScore(Double score) {
      this.score = score;
   }

   @Override
   public String toString() {
      return "PlayerStat{" +
              "playerId=" + playerId +
              ", played=" + played +
              ", point=" + point +
              ", score=" + score +
              '}';
   }

   public static PlayerStat newInstance(Integer id, Integer playerId){
      PlayerStat playerStat = new PlayerStat();
      playerStat.setId(id);
      playerStat.setPlayerId(playerId);
      playerStat.setPlayed(0);
      playerStat.setPoint(0);
      playerStat.setScore(0d);
      return playerStat;
   }

   public static PlayerStat newInstance(Integer id, Integer playerId, Integer played, Double score, Integer point){
      PlayerStat playerStat = new PlayerStat();
      playerStat.setId(id);
      playerStat.setPlayerId(playerId);
      playerStat.setPlayed(played);
      playerStat.setPoint(point);
      playerStat.setScore(score);
      return playerStat;
   }
}
