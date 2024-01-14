package org.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello OSGI World.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye OSGI World.");
    }
}
