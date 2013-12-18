package moda.mapper;

import moda.entity.TeamPlayer;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author omerbasar
 */
public class TeamPlayerRowMapper implements ResultSetMapper<TeamPlayer>
{
   public TeamPlayer map(int index, ResultSet r, StatementContext ctx) throws SQLException
   {
      return TeamPlayer.newInstance(r.getInt("player_id"), r.getInt("team_id"), r.getInt("score"), r.getInt("point"));
   }
}