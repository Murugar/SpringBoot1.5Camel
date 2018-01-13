package com.iqmsoft;

import org.apache.camel.builder.RouteBuilder;

public class IntegrationRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:target/inbox")
                .process(new LoggingProcessor())
                .bean(new TransformationBean(), "makeLowerCase")
        .to("file:target/outbox/dvd");
    }
}
