package com.lookup.controller;

import com.lookup.service.BaseService;
import com.lookup.service.impl.*;

public class LookupFactory {

    public static BaseService getService(String type){

        switch (type){
            case "category":
                return new DefaultCategoryService();

            case "complaint":
                return new DefaultComplaintService();
            case "order":
                return new DefaultOrderService();
            case "product":
                return new DefaultProductService();
            case "promo":
                return new DefaultPromoService();
            case "review":
                return new DefaultReviewService();
            case "user":
                return new DefaultUserService();
            default: return null;

        }


    }
}
