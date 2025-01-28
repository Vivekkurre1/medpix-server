package com.medicalstore.medicalstore.resolvers;

import java.util.*;
import com.medicalstore.medicalstore.handlers.Handler;
// This file will be automatically regenerated based on the schema, any resolver implementations
// will be copied through when generating and any unknown code will be moved to the end.

/**
 * Resolver for handling customer-related GraphQL mutations and queries.
 */
public class Customers {

    private final Handler handler;

    public Customers(Handler handler) {
        this.handler = handler;
    }

    // AddCustomer is the resolver for the addCustomer field.
    public AddCustomerResponse addCustomer(AddCustomerInput request) {
        return handler.addCustomer(request);
    }

    // UpdateCustomer is the resolver for the updateCustomer field.
    public UpdateCustomerResponse updateCustomer(UpdateCustomerInput request) {
        return handler.updateCustomer(request);
    }

    // DeleteCustomer is the resolver for the deleteCustomer field.
    public DeleteCustomerResponse deleteCustomer(DeleteCustomerInput request) {
        return handler.deleteCustomer(request);
    }

    // Customers is the resolver for the customers field.
    public CustomerConnection customers(CustomerFilter filter, Optional<Integer> first, Optional<String> after) {
        return handler.customers(filter, first, after);
    }

    // Customer is the resolver for the customer field.
    public Customer customer(String shopID, String customerID) {
        return handler.customer(shopID, customerID);
    }
}
