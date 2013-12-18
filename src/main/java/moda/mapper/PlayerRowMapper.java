package moda.mapper;

import moda.entity.Player;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author omerbasar
 */
public class PlayerRowMapper implements ResultSetMapper<Player>
{
   public Player map(int index, ResultSet r, StatementContext ctx) throws SQLException
   {
      return Player.newInstance(r.getInt("id"), r.getString("name"), r.getInt("rating"));
   }
}