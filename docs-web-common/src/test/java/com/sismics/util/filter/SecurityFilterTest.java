package com.sismics.util.filter;

import junit.framework.TestCase;
import org.glassfish.grizzly.servlet.FilterConfigImpl;

public class SecurityFilterTest extends TestCase {

    public void testInit() {

    }

    public void testDestroy() {
        SecurityFilter securityFilter=new HeaderBasedSecurityFilter();
        securityFilter.destroy();
    }

    public void testDoFilter() {
        SecurityFilter securityFilter=new HeaderBasedSecurityFilter();
        //...
    }

    public void testAuthenticate() {
        SecurityFilter securityFilter=new HeaderBasedSecurityFilter();
        //...
    }
}