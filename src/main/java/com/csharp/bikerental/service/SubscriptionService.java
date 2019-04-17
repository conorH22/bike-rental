package com.csharp.bikerental.service;

import com.csharp.bikerental.persistence.model.Customer;
import com.csharp.bikerental.persistence.model.Payment;
import com.csharp.bikerental.persistence.model.Subscriptions.AnnualSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.PayAsYouGoSubscription;
import com.csharp.bikerental.persistence.model.Subscriptions.Subscription;
import com.csharp.bikerental.persistence.model.Subscriptions.SubscriptionEnum;
import com.csharp.bikerental.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService   {

    @Autowired
    private UserService userService;

    public boolean buySubcription(String username, Payment payment, SubscriptionEnum subscriptionEnum){
        Customer u = (Customer) userService.getUserByUsername(username);
        if(u==null) return false;
        Subscription subscription = null;
        u.addSubscription(subscriptionEnum);
        userService.saveUser(u);
        return true;
    }

    public List<Subscription> getUserSubscriptions(String username) {
        User user = userService.getUserByUsername(username);
        Customer customer = null;
        try {
            customer = (Customer) user;
        }catch (ClassCastException e){
            System.out.println("Not a correct customer");
        }
        //TODO RETURN DTO INSTEAD OF
        return customer.getSubscriptions().getSubscriptions();
    }

}