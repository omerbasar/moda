package moda.entity;

/**
 * @author omerbasar
 */
public class Team {

   private Integer id;
   private Integer score;
   private Integer rating;
   private Integer point;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getScore() {
      return score;
   }

   public void setScore(Integer score) {
      this.score = score;
   }

   public Integer getRating() {
      return rating;
   }

   public void setRating(Integer rating) {
      this.rating = rating;
   }

   public Integer getPoint() {
      return point;
   }

   public void setPoint(Integer point) {
      this.point = point;
   }

   public static Team newInstance(Integer id, Integer score, Integer rating, Integer point) {
      Team team = new Team();
      team.id = id;
      team.score = score;
      team.rating = rating;
      team.point = point;
      return team;
   }
}
