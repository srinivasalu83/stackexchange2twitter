package org.tweet.meta.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.common.spring.CommonContextConfig;
import org.common.spring.CommonPersistenceJPAConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.keyval.spring.KeyValPersistenceJPAConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.stackexchange.util.SimpleTwitterAccount;
import org.stackexchange.util.TwitterTag;
import org.tweet.meta.spring.TwitterMetaConfig;
import org.tweet.meta.spring.TwitterMetaPersistenceJPAConfig;
import org.tweet.spring.TwitterConfig;
import org.tweet.spring.TwitterLiveConfig;

import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {// @formatter:off
        KeyValPersistenceJPAConfig.class, 
        
        CommonPersistenceJPAConfig.class, 
        CommonContextConfig.class, 
        
        TwitterConfig.class, 
        TwitterLiveConfig.class,
        TwitterMetaPersistenceJPAConfig.class, 
        
        TwitterMetaConfig.class 
}) // @formatter:on
public class TweetMetaServiceLiveTest {

    @Autowired
    private TweetMetaService tweetMetaService;

    // tests

    @Test
    public final void whenContextIsInitialized_thenNoExceptions() {
        //
    }

    @Test
    public final void whenTweetingAboutJQuery_thenNoExceptions() throws JsonProcessingException, IOException {
        final boolean success = tweetMetaService.retweetByHashtag(SimpleTwitterAccount.jQueryDaily.name(), TwitterTag.jquery.name());
        assertTrue(success);
    }

    @Test
    public final void whenTweetingAboutClojure_thenNoExceptions() throws JsonProcessingException, IOException {
        final boolean success = tweetMetaService.retweetByHashtag(SimpleTwitterAccount.BestClojure.name(), TwitterTag.clojure.name());
        assertTrue(success);
    }

    @Test
    public final void whenTweetingAboutScala_thenNoExceptions() throws JsonProcessingException, IOException {
        final boolean success = tweetMetaService.retweetByHashtag(SimpleTwitterAccount.BestScala.name(), TwitterTag.scala.name());
        assertTrue(success);
    }

    @Test
    public final void whenTweetingAboutGit_thenNoExceptions() throws JsonProcessingException, IOException {
        final boolean success = tweetMetaService.retweetByHashtag(SimpleTwitterAccount.BestGit.name(), TwitterTag.git.name());
        assertTrue(success);
    }

    @Test
    public final void whenTweetingAboutLisp_thenNoExceptions() throws JsonProcessingException, IOException {
        final boolean success = tweetMetaService.retweetByHashtag(SimpleTwitterAccount.LispDaily.name(), TwitterTag.lisp.name());
        assertTrue(success);
    }

    @Test
    public final void whenTweetingAboutCloud_thenNoExceptions() throws JsonProcessingException, IOException {
        final boolean success = tweetMetaService.retweetByHashtag(SimpleTwitterAccount.BestOfCloud.name(), TwitterTag.ec2.name());
        assertTrue(success);
    }

}
