package com.cskaoyan.mapper;

import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.bean.UnqualifyApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UnqualifyApplyMapper {



    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    List<UnqualifyApply> findByPage(HashMap<String,Object> map);

    List<UnqualifyApply> findUnqualifyByPage() ;

    int addUnqualify(UnqualifyApply unqualifyApply);

    int deleteById(@Param("ids")String[] ids);

    int updateUnqualify(UnqualifyApply unqualifyApply);

    List<UnqualifyApply> searchById(@Param("id")  String id,@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    List<UnqualifyApply> searchByName(@Param("name") String name,@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
}