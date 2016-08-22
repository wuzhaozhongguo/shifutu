package com.xianyu.facade.com.xianyu.controller;
import com.xianyu.facade.IShifutuFacade;
import com.xianyu.facade.com.xianyu.dto.ShiFuTuDTO;
import com.xianyu.facade.com.xianyu.util.HttpUtils;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/22 0022.
 */

@Controller
@RequestMapping("/shifutu")
public class IShifutuController {
    @RequestMapping("/queryImgs")
    @ResponseBody
    public List<ShiFuTuDTO> queryImgs() {
        List<ShiFuTuDTO> shiFuTuDTO = this.getShiFuTuDTO();
        return shiFuTuDTO;
    }

    @RequestMapping("/helloWord")
    @ResponseBody
    public String helloWord() {
        return "HELLO WORD!";
    }

    public List<ShiFuTuDTO> getShiFuTuDTO(){
        List<ShiFuTuDTO> shiFuTuDTOs = new ArrayList<ShiFuTuDTO>();
        HttpUtils httpUtils = new HttpUtils();
        HttpEntity httpEntity = httpUtils.sendGet("http://www.10futu.com/", null);
        String content = null;
        try {
            content = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document parse = Jsoup.parse(content);
        Elements elementsByClass = parse.getElementsByClass("sjh_ten_img");
        if (elementsByClass != null){
            for (Element element : elementsByClass){
                Elements imgs = element.getElementsByTag("img");
                for (Element img : imgs){
                    String imgUrl = img.attr("src");
                    String description = img.attr("alt");
                    ShiFuTuDTO shiFuTuDTO = new ShiFuTuDTO();
                    shiFuTuDTO.setImgUrl(imgUrl);
                    shiFuTuDTO.setDescription(description);
                    shiFuTuDTOs.add(shiFuTuDTO);
                }

            }
        }
        return shiFuTuDTOs;
    }
}
