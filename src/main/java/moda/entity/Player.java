package moda.entity;

/**
 * @author omerbasar
 */
public class Player {

   private Integer id;
   private String name;
   private Integer rating;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getRating() {
      return rating;
   }

   public void setRating(Integer rating) {
      this.rating = rating;
   }

   public static Player newInstance(Integer id, String name, Integer rating) {
      Player player = new Player();
      player.setId(id);
      player.setName(name);
      player.setRating(rating);
      return player;
   }
}
