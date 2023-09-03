package plugin.enemydown.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plugin.enemydown.app.mapper.data.GameConfig;
import plugin.enemydown.app.mapper.data.SpawnEnemy;

import java.util.List;

/**
 * @MapperをつけるとMybatisが使用できるようになる
 */
@Mapper
public interface GameConfigMapper {

//    GameConfigクラスから情報を取得してselectConfigListに入れる。
    @Select("select * from game_config order by id asc")
    List<GameConfig> selectConfigList();

    @Select("select * from game_config where difficulty = #{difficulty} order by id asc")
    GameConfig selectConfig(String difficulty);

    //inner joinで結合することにより未実装なものは隠蔽できる
    @Select("select * from spawn_enemy inner join game_config on spawn_enemy.difficulty = game_config.difficulty where spawn_enemy.difficulty = #{difficulty} order by spawn_enemy.id asc")
    List<SpawnEnemy> selectSpawnEnemyList(String difficulty);
}