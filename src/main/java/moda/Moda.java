package moda;

import moda.service.ModaService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author omerbasar
 */
public class Moda {

   ModaService modaService = new ModaService();
   DateFormat simpleDataFormat = new SimpleDateFormat("dd.MM.yyyy");

   public static void main(String[] args) throws Exception{
      new Moda().run();
   }

   private void run() throws Exception {
      modaService.deleteAll();
      insertGames();

      modaService.calculateStatsAccordingTo(1);
   }

   private void insertGames() throws ParseException {
   /*
   modaService.insertGame(simpleDataFormat.parse("22.09.2013"),
           createPlayerNameScoreMap("Erol", 0, "Halil", 3, "Taylan", 5, "Kamil", 0),
           createPlayerNameScoreMap("Osman", 3, "Emrah", 1, "Guray", 0, "Cem", 1));

   modaService.insertGame(simpleDataFormat.parse("26.10.2013"),
           createPlayerNameScoreMap("Bilal", 2, "Oktay", 0, "Ömer", 3, "Halil", 2),
           createPlayerNameScoreMap("Erol", 2, "Habil", 1, "Emrah", 1, "Osman", 3));
   */

      modaService.insertGame(simpleDataFormat.parse("04.10.2013"),
              createPlayerNameScoreMap("Erol", 2, "Osman", 7, "Taylan", 2, "Halil", 1),
              createPlayerNameScoreMap("Oktay", 2, "Burçin", 3, "Cihan", 0, "Caner", 4));

      modaService.insertGame(simpleDataFormat.parse("20.10.2013"),
              createPlayerNameScoreMap("Bilal", 2, "Osman", 3, "Ömer", 2, "Halil", 0),
              createPlayerNameScoreMap("Burçin", 0, "Taylan", 0, "Erol", 2, "Kaan", 3));

      modaService.insertGame(simpleDataFormat.parse("23.11.2013"),
              createPlayerNameScoreMap("Osman", 4, "Taylan", 3, "Cihan", 2, "Halil", 0),
              createPlayerNameScoreMap("Bilal", 2, "Erol", 0, "Emrah", 1, "Oktay", 0));

      modaService.insertGame(simpleDataFormat.parse("03.12.2013"),
              createPlayerNameScoreMap("Osman", 2, "Taylan", 2, "Burçin", 1, "Kaan", 0),
              createPlayerNameScoreMap("Bilal", 2, "Cihan", 0, "Ömer", 0, "Oktay", 0));

      modaService.insertGame(simpleDataFormat.parse("07.12.2013"),
              createPlayerNameScoreMap("Bilal", 2, "Erol", 2, "Caner", 0, "Emrah", 0),
              createPlayerNameScoreMap("Osman", 1, "Taylan", 0, "Halil", 1, "Kaan", 1));

      modaService.insertGame(simpleDataFormat.parse("10.12.2013"),
              createPlayerNameScoreMap("Bilal", 2, "Cihan", 5, "Askin", 3, "Emrah", 3),
              createPlayerNameScoreMap("Osman", 2, "Taylan", 1, "Caner", 3, "Oktay", 0));

      modaService.insertGame(simpleDataFormat.parse("15.09.2013"),
              createPlayerNameScoreMap("Erol", 2, "Oktay", 3, "Burçin", 3, "Cihan", 3),
              createPlayerNameScoreMap("Osman", 3, "Emrah", 2, "Halil", 1, "Cem", 0));

      modaService.insertGame(simpleDataFormat.parse("29.09.2013"),
              createPlayerNameScoreMap("Bilal", 1, "Erol", 3, "Halil", 4, "Oktay", 2),
              createPlayerNameScoreMap("Osman", 3, "Emrah", 0, "Cem", 1, "Cihan", 2));

      modaService.insertGame(simpleDataFormat.parse("02.11.2013"),
              createPlayerNameScoreMap("Bilal", 6, "Ömer", 3, "Oktay", 0, "Caner", 1),
              createPlayerNameScoreMap("Burçin", 0, "Osman", 1, "Emrah", 0, "Halil", 2));

      modaService.insertGame(simpleDataFormat.parse("02.11.2013"),
              createPlayerNameScoreMap("Osman", 0, "Ömer", 1, "Burçin", 1, "Emrah", 2),
              createPlayerNameScoreMap("Bilal", 0, "Caner", 0, "Halil", 2, "Askin", 1));

      modaService.insertGame(simpleDataFormat.parse("09.11.2013"),
              createPlayerNameScoreMap("Bilal", 5, "Emrah", 2, "Halil", 3, "Oktay", 0),
              createPlayerNameScoreMap("Erol", 1, "Osman", 2, "Burçin", 2, "Cihan", 4));

      modaService.insertGame(simpleDataFormat.parse("19.11.2013"),
              createPlayerNameScoreMap("Bilal", 2, "Cihan", 2, "Halil", 1, "Oktay", 3),
              createPlayerNameScoreMap("Erol", 0, "Osman", 2, "Emrah", 3, "Ömer", 0));

      modaService.insertGame(simpleDataFormat.parse("26.11.2013"),
              createPlayerNameScoreMap("Bilal", 5, "Erol", 3, "Caner", 5, "Oktay", 1),
              createPlayerNameScoreMap("Osman", 3, "Emrah", 0, "Cihan", 0, "Halil", 4));

      modaService.insertGame(simpleDataFormat.parse("30.11.2013"),
              createPlayerNameScoreMap("Bilal", 2, "Osman", 8, "Erol", 5, "Oktay", 0),
              createPlayerNameScoreMap("Cihan", 0, "Ömer", 1, "Kaan", 1, "Halil", 3));

      modaService.insertGame(simpleDataFormat.parse("14.12.2013"),
              createPlayerNameScoreMap("Bilal", 2, "Erol", 3, "Oktay", 2, "Emrah", 4),
              createPlayerNameScoreMap("Osman", 1, "Ömer", 4, "Halil", 1, "Burçin", 0));

      modaService.insertGame(simpleDataFormat.parse("17.12.2013"),
              createPlayerNameScoreMap("Bilal", 0, "Erol", 4, "Oktay", 0, "Ömer", 5),
              createPlayerNameScoreMap("Osman", 1, "Kaan", 1, "Halil", 0, "Cihan", 1));

      modaService.insertGame(simpleDataFormat.parse("21.12.2013"),
              createPlayerNameScoreMap("Bilal", 1, "Oktay", 4, "Emrah", 1, "Erol", 1),
              createPlayerNameScoreMap("Osman", 2, "Ömer", 1, "Halil", 0, "Caner", 4));

      modaService.insertGame(simpleDataFormat.parse("24.12.2013"),
              createPlayerNameScoreMap("Bilal", 4, "Erol", 1, "Oktay", 1, "Askin", 2),
              createPlayerNameScoreMap("Osman", 2, "Ömer", 2, "Halil", 1, "Cihan", 0));

      modaService.insertGame(simpleDataFormat.parse("28.12.2013"),
              createPlayerNameScoreMap("Taylan", 4, "Erol", 1, "Burçin", 0, "Halil", 1),
              createPlayerNameScoreMap("Bilal", 0, "Osman", 2, "Oktay", 0, "Emrah", 0));

   }

   private Map<String, Integer> createPlayerNameScoreMap(String name1, Integer score1,
                                         String name2, Integer score2,
                                         String name3, Integer score3,
                                         String name4, Integer score4){
      Map<String, Integer> map = new HashMap<String, Integer>();
      map.put(name1, score1);
      map.put(name2, score2);
      map.put(name3, score3);
      map.put(name4, score4);
      return map;
   }
}
