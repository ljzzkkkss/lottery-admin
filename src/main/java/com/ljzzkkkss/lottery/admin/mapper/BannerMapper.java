package com.ljzzkkkss.lottery.admin.mapper;

import com.ljzzkkkss.lottery.admin.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    List<Banner> getBannerList();
    void insertBanner(Banner banner);
    void updateBannerById(Banner banner);
    void deleteBannerById(@Param("id")Integer id);
}
