package org.cart.command.service.command;

import org.cart.domain.service.model.Product;

public class UpdateProductQuantityCommand implements ProductCommand {

    private String id;
    private Product product;

    public UpdateProductQuantityCommand(String id, Product product) {
        this.id = id;
        this.product = product;
    }

    public String getId() {
        return this.id;
    }

    public Product getProduct() {
        return this.product;
    }
}
