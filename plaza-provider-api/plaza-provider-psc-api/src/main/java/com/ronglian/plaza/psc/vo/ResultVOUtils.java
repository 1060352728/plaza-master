package com.ronglian.plaza.psc.vo;

/**
 * 封装返回结果
 * @author： likui
 * @great： 2018/10/9 14:55
 */ 
public class ResultVOUtils {

    /**
     * @methord: success  格式化返回结果
     * @author： likui
     * @great： 2018/10/8 22:38
     * @param： [object]
     * @return： ResultVO
     * @throws:
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
