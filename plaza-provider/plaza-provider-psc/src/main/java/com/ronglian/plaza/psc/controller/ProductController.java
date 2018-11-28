package com.ronglian.plaza.psc.controller;

import com.ronglian.plaza.common.entity.psc.ProductCategroy;
import com.ronglian.plaza.common.entity.psc.ProductInfo;
import com.ronglian.plaza.common.entity.psc.ProductInfoOutput;
import com.ronglian.plaza.psc.common.DecreaseStockInput;
import com.ronglian.plaza.psc.enums.ProductStatusEnum;
import com.ronglian.plaza.psc.vo.ProductInfoVO;
import com.ronglian.plaza.psc.vo.ProductVO;
import com.ronglian.plaza.psc.vo.ResultVO;
import com.ronglian.plaza.psc.vo.ResultVOUtils;
import com.ronglian.plaza.psc.service.ProductCategroyService;
import com.ronglian.plaza.psc.service.ProductInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author likui
 * @Classname: ProductController
 * @Description: 产品控制器
 * @create 2018-09-20 11:42
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategroyService productCategroyService;

    /**
     * @methord: findProductList
     * @author： likui
     * @great： 2018/9/30 10:57
     * 1：查询在架的商品
     * 2：获取类目type列表
     * 3：查询类目
     * 4：构造数据
     */
    @GetMapping("/list")
    @ApiOperation(value = "查询在架的商品")
    public ResultVO<ProductVO> findProductList(){
        //１：查询在架的商品
        List<ProductInfo> productInfos = productInfoService.findByProductStatus(ProductStatusEnum.UP.getCode());
        //２：获取类目type列表
        List<Integer> categroyTypes = productInfos.stream().map(ProductInfo::getCategroyType).collect(Collectors.toList());
        //３：查询类目
        List<ProductCategroy> productCategroys = productCategroyService.findByCategroyTypeIn(categroyTypes);
        //４：构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategroy productCategroy : productCategroys){
            ProductVO productVO = new ProductVO();
            productVO.setCategroyName(productCategroy.getCategroyName());
            productVO.setCategroyType(productCategroy.getCategroyType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos){
                if(productInfo.getCategroyType().equals(productCategroy.getCategroyType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }

    /**
     * 根据订单中的产品标号查询产品
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){
        return productInfoService.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productInfoService.decreaseStock(decreaseStockInputList);
        /*int i = 10/0;*/
    }
}
