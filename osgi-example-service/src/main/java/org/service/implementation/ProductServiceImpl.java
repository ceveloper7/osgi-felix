package org.service.implementation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.service.definition.ProductService;

import java.util.HashSet;
import java.util.Set;

public class ProductServiceImpl implements ProductService, BundleActivator {

    private ServiceRegistration<ProductService> serviceRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("osgi-example-service: Starting service...");

        ProductServiceImpl productService = new ProductServiceImpl();
        serviceRegistration = context.registerService(ProductService.class, productService, null);

        System.out.println("osgi-example-service: Service registered");

    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("osgi-example-service: Stopping service...");

        if (serviceRegistration !=null) {
            serviceRegistration.unregister();
            System.out.println("osgi-example-service: Service unregistered");
        }

    }

    @Override
    public boolean checkProductExists(String productName) {
        Set<String> availableProducts = new HashSet<>();
        availableProducts.add("Laptop");
        availableProducts.add("Smartphone");
        availableProducts.add("Headphone");

        return availableProducts.contains(productName);
    }
}
