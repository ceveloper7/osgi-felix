package com.ceva.hello.impl;

import com.ceva.hello.GreetingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GreetingServiceImpl implements GreetingService, BundleActivator {
    private ServiceRegistration<GreetingService> serviceRegistration;
    private String m_name;

    public GreetingServiceImpl(){}

    public GreetingServiceImpl(String name){
        this.m_name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello: " + m_name);
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("osgi-greeting-service: Starting service...");

        GreetingServiceImpl greetingService = new GreetingServiceImpl("Carlos");
        serviceRegistration = bundleContext.registerService(GreetingService.class, greetingService, null);

        System.out.println("sgi-greeting-service: Service registered");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("osgi-greeting-service: Stopping service...");
        if (serviceRegistration !=null) {
            serviceRegistration.unregister();
            System.out.println("osgi-greeting-service: Service unregistered");
        }
    }
}
