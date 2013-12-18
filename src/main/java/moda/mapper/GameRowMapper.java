package moda.mapper;

import moda.entity.Game;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author omerbasar
 */
public class GameRowMapper implements ResultSetMapper<Game>
{
   public Game map(int index, ResultSet r, StatementContext ctx) throws SQLException
   {
      return Game.newInstance(r.getInt("id"), r.getDate("played_time"), r.getInt("home_team_id"), r.getInt("away_team_id"));
   }
}