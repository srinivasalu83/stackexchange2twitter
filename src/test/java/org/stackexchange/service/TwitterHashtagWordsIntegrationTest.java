package org.stackexchange.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.spring.StackexchangeConfig;
import org.stackexchange.util.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StackexchangeConfig.class })
public class TwitterHashtagWordsIntegrationTest {

    @Autowired
    private Environment env;

    // API

    @Test
    public final void whenRetrievingMinStackExchangeScoreForTag_thenFound() {
        for (final Tag tag : Tag.values()) {
            assertNotNull("No min score for tag " + tag, env.getProperty(tag.name() + ".minscore"));
        }
    }

}
