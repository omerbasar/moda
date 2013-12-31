package moda.dao;

import moda.entity.Game;
import moda.mapper.GameRowMapper;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * @author omerbasar
 */
public interface GameDAO {

   @SqlUpdate("insert into game (played_time, home_team_id, away_team_id, home_team_coef, away_team_coef) values(:g.playedTime, :g.homeTeamId, :g.awayTeamId, :g.homeTeamCoef, :g.awayTeamCoef)")
   Integer insert(@BindBean("g") Game game);

   @SqlUpdate("delete from game")
   void deleteAll();

   @SqlQuery("select * from game")
   @Mapper(GameRowMapper.class)
   List<Game> selectAll();
}
