package com.ljzzkkkss.lottery.admin.service.impl;

import com.ljzzkkkss.lottery.admin.mapper.BannerMapper;
import com.ljzzkkkss.lottery.admin.model.Banner;
import com.ljzzkkkss.lottery.admin.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;


    @Override
    public List<Banner> getBannerList() {
        return bannerMapper.getBannerList();
    }

    @Override
    public void insertBanner(Banner banner) {
        bannerMapper.insertBanner(banner);
    }

    @Override
    public void updateBannerById(Banner banner) {
        bannerMapper.updateBannerById(banner);
    }

    @Override
    public void deleteBannerById(Integer id) {
        bannerMapper.deleteBannerById(id);
    }
}
