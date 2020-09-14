package com.ljzzkkkss.lottery.admin.service;

import com.ljzzkkkss.lottery.admin.model.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {
    List<Banner> getBannerList();
    void insertBanner(Banner banner);
    void updateBannerById(Banner banner);
    void deleteBannerById(Integer id);
}
