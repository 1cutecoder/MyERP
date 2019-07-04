package com.cskaoyan.service;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.Order;

import java.util.List;

/**
 * Created by cute coder
 * 2019/5/19 13:33
 */
public interface ManufactureService {

    List<Manufacture> findPageManufacture(int page, int rows);

    Long selectTotalCount();

    int insert(Manufacture manufacture);

    int deleteBatch(String[] ids);

    int updateByPrimaryKey(Manufacture manufacture);

    List<Manufacture> selectAllCustom();

    List<Manufacture> selectManufactureLikeManufactureSn(String searchValue, int page, int rows);

    Long selectTotalCountLikeSn(String searchValue);

    List<Manufacture> selectManufactureLikeManufactureOrderId(String searchValue, int page, int rows);

    Long selectTotalCountLikeOrderId(String searchValue);

    List<Manufacture> selectManufactureLikeManufactureTechnologyName(String searchValue, int page, int rows);

    Long selectTotalCountLikeTechnologyName(String searchValue);

}
