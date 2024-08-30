package com.vmware.tanzu.streams.functions;

import java.util.Collections;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.cloud.function.context.PollableBean;
import org.springframework.context.annotation.Configuration;

import com.vmware.tanzu.streams.model.Foo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Configuration
@Slf4j
public class FooSource 
{
	@PollableBean
	public Supplier<Flux<Foo>> supplyFoo()
	{
		return () -> {

			log.info("Supplier generating new {}",  Foo.class.getName());
			return Flux.fromIterable(Collections.singletonList(new Foo("Test data: " + UUID.randomUUID().toString())));
		};
	}
}
