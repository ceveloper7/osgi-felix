package com.ceva.client;

import com.ceva.hello.GreetingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Main implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference<GreetingService> serviceReference = bundleContext.getServiceReference(GreetingService.class);

        if (serviceReference != null){
            GreetingService greetingService = bundleContext.getService(serviceReference);
            greetingService.sayHello();
        }
        else{
            System.out.println("Client bundle: ProductService not found.");
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Client bundle is stopping...");
    }
}
