import java.util.*;

/**
 * Created by yvan on 9/13/16.
 */
public class Twitter {
    class tweet{
        int time;
        int tweetId;
        tweet(int time,int tweetId){
            this.time=time;
            this.tweetId=tweetId;
        }
    }
    Map<Integer, Set<Integer>> fans = new HashMap<>();
    Map<Integer, LinkedList<tweet>> tweets = new HashMap<>();
    int cnt = 0;
    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            LinkedList<tweet> tw=new LinkedList();
            tw.add(new tweet(cnt++,tweetId));
            tweets.put(userId,tw);
            follow(userId,userId);
        }else{
            tweets.get(userId).add(new tweet(cnt++,tweetId));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new LinkedList<Integer>();
        PriorityQueue<tweet> minheap=new PriorityQueue<tweet>(10,(t1,t2)->t2.time-t1.time);
        if(!fans.containsKey(userId)){
            return result;
        }
        Iterator followees=fans.get(userId).iterator();
        while(followees.hasNext()){
            Integer followee=(Integer) followees.next();
            if(tweets.containsKey(followee)){
                Iterator tweet_list=tweets.get(followee).iterator();
                while (tweet_list.hasNext()){
                    tweet tweet_temp=(tweet)tweet_list.next();
                    minheap.add(tweet_temp);
                }
            }
        }
        int i=0;
        while(minheap.size()>0&&i<10){
            result.add(minheap.poll().tweetId);
            i++;
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!fans.containsKey(followerId)){
            Set set=new HashSet<Integer>();
            set.add(followeeId);
            fans.put(followerId,set);
        }else{
            Set set=fans.get(followerId);
            if(!set.contains(followeeId)){
                set.add(followeeId);
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(fans.containsKey(followerId)&&followeeId!=followerId){
            Set set=fans.get(followerId);
            if(set.contains(followeeId)){
                set.remove(followeeId);
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */