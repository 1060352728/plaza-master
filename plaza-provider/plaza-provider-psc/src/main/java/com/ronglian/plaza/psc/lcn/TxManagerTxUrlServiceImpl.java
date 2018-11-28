package com.ronglian.plaza.psc.lcn;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * 整合lcn框架，事物响应方
 * create by lorne on 2017/11/18
 */


@Service(value = "txManagerTxUrlServiceImpl")
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService{


    @Value("${tm.manager.url}")
    private String url;

    @Override
    public String getTxUrl() {
        System.out.println("load tm.manager.url ");
        return url;
    }
}
