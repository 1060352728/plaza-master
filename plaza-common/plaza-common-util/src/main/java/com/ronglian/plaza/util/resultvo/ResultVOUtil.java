package com.ronglian.plaza.util.resultvo;

/**
 * Created by likui
 * 2018-10-9 20:34
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("返回成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        resultVO.setData(null);
        return resultVO;
    }
}
