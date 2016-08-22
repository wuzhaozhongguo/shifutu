package com.xianyu.facade;

import com.xianyu.facade.com.xianyu.dto.ShiFuTuDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22 0022.
 */

public interface IShifutuFacade {

    List<ShiFuTuDTO> queryImgs();

}
