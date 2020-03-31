package com.cxyhome.top.itemservicecompose.mapper;

import com.cxyhome.top.microserviceitem.info.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper {
//	@Select("SELECT demo_id,code,name FROM demo")
//	List<Item> findAll();
//
//	@Select("SELECT demo_id,code,name FROM demo WHERE code=#{code}")
//	Demo getDemoByCode(String code);
//
//	@Insert("INSERT INTO demo(demo_id, code, name) VALUES(#{demoId}, #{code}, #{name})")
//	void save(Demo demo);
//
//	@Update("UPDATE demo SET code=#{code}, name=#{name} WHERE demo_id=#{demoId}")
//	void update(Demo demo);
//
//	@Delete("Delete FROM demo WHERE demo_id=#{demoId}")
//	void delete(String id);

	@Select("select item_id as id,t.* from  t_item t  where item_id = #{id}")
	Item queryItemById(String id);


}
