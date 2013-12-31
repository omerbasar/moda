package moda.mapper;

import moda.entity.Team;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author omerbasar
 */
public class TeamRowMapper implements ResultSetMapper<Team>
{
   public Team map(int index, ResultSet r, StatementContext ctx) throws SQLException
   {
      return Team.newInstance(r.getInt("id"), r.getInt("score"), r.getInt("rating"), r.getInt("point"));
   }
}