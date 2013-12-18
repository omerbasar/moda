package moda.dao;

import moda.entity.Team;
import moda.entity.TeamPlayer;
import moda.mapper.PlayerRowMapper;
import moda.mapper.TeamPlayerRowMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * @author omerbasar
 */
public interface TeamPlayerDAO {

   @SqlUpdate("insert into team_player (player_id, team_id, score, point) values(:tp.playerId, :tp.teamId, :tp.score, :tp.point)")
   Integer insert(@BindBean("tp") TeamPlayer teamPlayer);

   @SqlUpdate("delete from team_player")
   void deleteAll();

   @SqlQuery("SELECT * FROM team_player")
   @Mapper(TeamPlayerRowMapper.class)
   List<TeamPlayer> selectAll();

   @SqlQuery("SELECT * FROM team_player where team_id = :teamId")
   @Mapper(TeamPlayerRowMapper.class)
   List<TeamPlayer> select(@Bind("teamId") Integer teamId);
}
