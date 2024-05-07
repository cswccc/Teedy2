package com.sismics.security;

import junit.framework.TestCase;

public class UserPrincipalTest extends TestCase {

    public void testGetId() {
        UserPrincipal userPrincipal1 = new UserPrincipal("1", "csw");

        String s = userPrincipal1.getId();
    }
}