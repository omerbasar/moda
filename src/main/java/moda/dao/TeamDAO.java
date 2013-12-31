package moda.dao;

import moda.entity.Team;
import moda.mapper.TeamRowMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * @author omerbasar
 */
public interface TeamDAO {

   @SqlUpdate("insert into team (score, rating, point) values(:t.score, :t.rating, :t.point)")
   @GetGeneratedKeys
   Integer insert(@BindBean("t") Team team);

   @SqlUpdate("delete from team")
   void deleteAll();

   @SqlQuery("SELECT * FROM team WHERE team_id = :teamId")
   @Mapper(TeamRowMapper.class)
   Team getTeam(@Bind("teamId") Integer teamId);
}
