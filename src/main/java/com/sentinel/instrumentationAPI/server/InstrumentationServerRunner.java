package com.sentinel.instrumentationAPI.server;

import com.sentinel.instrumentationAPI.impl.InstrumentResourceImpl;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.ContextResolver;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sebastian on 12/14/15.
 */
public class InstrumentationServerRunner {

    public static void main(final String[] args) throws URISyntaxException, IOException {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig(InstrumentResourceImpl.class);
        config.packages("org.glassfish.jersey.examples.jsonmoxy").register(createMoxyJsonResolver());
        HttpServer grizzlyServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        grizzlyServer.start();
        InstrumentationServerManager instrumentationServerManager = InstrumentationServerManager.getInstance();
        instrumentationServerManager.setupDatabase();
    }



    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }
}
