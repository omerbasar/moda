package moda.dao;

import moda.mapper.PlayerRowMapper;
import moda.entity.Player;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * @author omerbasar
 */
public interface PlayerDAO {

   @Mapper(PlayerRowMapper.class)
   @SqlQuery("SELECT * FROM player")
   List<Player> getPlayers();
}
