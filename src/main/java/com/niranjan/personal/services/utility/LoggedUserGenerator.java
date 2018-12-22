package com.niranjan.personal.services.utility;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

public class LoggedUserGenerator implements ValueGenerator<String> {
 
    @Override
    public String generateValue(
            Session session, Object owner) {
        return LoggedUser.get();
    }
}