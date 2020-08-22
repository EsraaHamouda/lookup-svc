package com.lookup.controller;

import com.lookup.service.BaseService;
import com.lookup.service.impl.*;

public class LookupFactory {

    public static BaseService getService(String type){

        switch (type){
            case "Category":
                return new DefaultCategoryService();

            case "Complaint":
                return new DefaultComplaintService();
            case "Order":
                return new DefaultOrderService();
            case "Product":
                return new DefaultProductService();
            case "Promo":
                return new DefaultPromoService();
            case "Review":
                return new DefaultReviewService();
            case "User":
                return new DefaultUserService();
            default: return null;

        }


    }
}
