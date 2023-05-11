package org.drools.demo20230511;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.runtime.KieRuntimeBuilder;
import org.kie.api.runtime.KieSession;

@Path("/reproducer")
public class MyEndpoint {

    @Inject
    KieRuntimeBuilder kieRuntimeBuilder;

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object executeQuery(String something) {
        return ut(kieRuntimeBuilder, something);
    }

    public static Object ut(KieRuntimeBuilder kieRuntimeBuilder,String something) {
        KieSession session = kieRuntimeBuilder.newKieSession();

        session.insert(something);
        session.fireAllRules();

        return session.getObjects(x -> !(x instanceof String));
    }
}