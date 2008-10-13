/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.jms.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.integration.config.xml.SimpleHeaderEnricherParser;
import org.springframework.integration.jms.JmsHeaders;

/**
 * Namespace handler for Spring Integration's <em>jms</em> namespace.
 * 
 * @author Mark Fisher
 */
public class JmsNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		this.registerBeanDefinitionParser("jms-gateway", new JmsGatewayParser());
		this.registerBeanDefinitionParser("inbound-channel-adapter", new JmsInboundChannelAdapterParser());
		this.registerBeanDefinitionParser("outbound-channel-adapter", new JmsOutboundChannelAdapterParser());
		this.registerBeanDefinitionParser("header-enricher", new SimpleHeaderEnricherParser(
				JmsHeaders.TRANSPORT_PREFIX, new String[] { "reply-to" }));
	}

}
