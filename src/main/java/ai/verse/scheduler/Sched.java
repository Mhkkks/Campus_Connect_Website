package ai.verse.scheduler;


import ai.verse.Sentiment;
import ai.verse.repo.AadhaarRepository;
import ai.verse.repo.PostEntity;
import ai.verse.repo.PostRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
public class Sched {
    @Autowired
    PostRepository postRepository;

    @Autowired
    AadhaarRepository aadhaarRepository;


    // Call this automatically every 10 seconds
    @Scheduled(fixedRate = 10000)
    public void testData() {
        System.out.println(" --------------- testData Called on:" + new Date());
        List data = aadhaarRepository.findAll();
       System.out.println(data);

    }


    //  @Scheduled(fixedRate = 10000)
    public void scheduledMethod() {
      //  System.out.println(" --------------- scheduledMethod Called on:" + new Date());

        // List<PostEntity> list = postRepository.findAll();  // Get all posts from database

        List<PostEntity> list = postRepository.findRowsWithNoSentiment();  // Lists posts with no sentiment

    //    System.out.println("--- NUMBER OF ROWS WITH NO SENTIMENT IS:  --->>" + list.size());

//        // Here we are iterating over all the posts and calling sentimen class
//        for (int h = 0; h < list.size(); h++) {
//            Sentiment sm = new Sentiment();
//            PostEntity post = list.get(h);   // This will get post in a loop
//            String sentm = sm.getSentimentOfText(post.getPost());
//            post.setSentiment(sentm);
//            postRepository.save(post);  // save in database
//        //    System.out.println(post);
//        }
    }


}