package com.github.saviobarr.microprofile;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigSource;

@Path("mp-config")
public class MPConfigResource {
	
	@Inject
	Config config;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("config-sources")
	public String getConfigSources() {
		
		Iterable<ConfigSource> configSources = config.getConfigSources();
		
		StringBuilder sb = new StringBuilder();
		
		for (ConfigSource configSource : configSources) {
			sb.append("NOME:").append(configSource.getName())
			.append("\n ORDINAL: ").append(configSource.getOrdinal())
			.append("PROPERTY-NAMES: ").append(config.getPropertyNames());
			
		}
		
		return sb.toString();
		
	}

}
