package com.zking.ssm.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {


    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        
        Object[] prames = args.getArgs();
        PageBean pageBean = null;
        for (Object prame : prames) {
            if(prame instanceof PageBean){
                pageBean = (PageBean)prame;
                break;
            }
        }

        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        Object result = args.proceed(prames);
        if(null!=pageBean&&pageBean.isPagination()){
            List lst = (List)result;
            PageInfo pageInfo = new PageInfo(lst);
            pageBean.setTotal(pageInfo.getTotal()+"");
        }
        return result;
    }
}
