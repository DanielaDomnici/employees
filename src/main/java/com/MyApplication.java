package com;

import com.resource.Api;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by daniela.domnici on 12/11/15.
 */

/**
 * Public class used for declaring the root resource and the provider class
 * This class extend the Jersey Application class
 */
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(Api.class);
        return s;
    }
}
