package moda.dao;

import moda.entity.Team;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * @author omerbasar
 */
public interface TeamDAO {

   @SqlUpdate("insert into team (score, rating, point) values(:t.score, :t.rating, :t.point)")
   @GetGeneratedKeys
   Integer insert(@BindBean("t") Team team);

   @SqlUpdate("delete from team")
   void deleteAll();

}
