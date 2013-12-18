package moda.dao;

import moda.entity.PlayerStat;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * @author omerbasar
 */
public interface PlayerStatDAO {

   @SqlUpdate("insert into player_stat (id, player_id, played, score, point) values(:ps.id, :ps.playerId, :ps.played, :ps.score, :ps.point)")
   @GetGeneratedKeys
   Integer insert(@BindBean("ps") PlayerStat playerStat);

   @SqlUpdate("delete from player_stat")
   void deleteAll();

}
