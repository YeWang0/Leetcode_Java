/**
 * Created by yvan on 10/22/16.
 */
import java.awt.*;
import java.util.*;
import java.util.List;

public class Twitter {
    HashMap<Integer,HashSet<Integer>> followers=new HashMap<>();
    // HashMap<Integer,HashSet<Integer>> followees=new HashMap<>();
    HashMap<Integer,ArrayList<ArrayList<Integer>>> tweets=new HashMap<>();

    int time=0;
    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        ArrayList<Integer> tweet=new ArrayList<>();
        tweet.add(tweetId);
        tweet.add(time++);
        ArrayList<ArrayList<Integer>> tweetList;
        if(tweets.containsKey(userId)){
            tweetList=new ArrayList<>(tweets.get(userId));
            tweetList.add(tweet);
            tweets.put(userId,tweetList);
        }
        else{
            tweetList=new ArrayList<>();
            tweetList.add(tweet);
            tweets.put(userId,tweetList);
        }
        // for(Map.Entry<Integer,ArrayList<ArrayList<Integer>>> entry : tweets.entrySet()){
        //     System.out.println("userId: "+entry.getKey());
        //     Iterator<ArrayList<Integer>> it = entry.getValue().iterator();
        //     while (it.hasNext()) {
        //         System.out.print("post:"+it.next());
        //     }
        //     System.out.println();
        // }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<ArrayList<Integer>> tweetList=new ArrayList<>();
        HashSet<Integer> followeeList;
        if(followers.containsKey(userId)) {
            // System.out.println("getNewsFeed:"+userId);
            if(followers.containsKey(userId)){
                followeeList = followers.get(userId);
            }
            else{
                followeeList = new HashSet<Integer>();
            }
            if (!followeeList.contains(userId)) {
                followeeList.add(userId);
            }
            Iterator<Integer> it = followeeList.iterator();
            while (it.hasNext()) {
                int followeeID = it.next();
                if (tweets.containsKey(followeeID)) {
                    tweetList.addAll(tweets.get(followeeID));
                }
            }
        }
        else{
            if (tweets.containsKey(userId)) {
                tweetList.addAll(tweets.get(userId));
            }
        }

        ArrayList<Integer> news=new ArrayList<>();
        ArrayList<Integer> times=new ArrayList<>();
        for(int i=0;i<tweetList.size();i++) {
            ArrayList<Integer> tweet = tweetList.get(i);
            int tId = tweet.get(0);
            int tTime = tweet.get(1);
            // System.out.println("Tweet list:"+tId+" time:"+tTime);
            boolean flag=false;
            for(int j=0;j<times.size();j++){
                flag=false;
                if(tTime>times.get(j)){
                    times.add(j,tTime);
                    news.add(j,tId);
                    flag=true;
                    break;
                }
            }
            if(times.size()<10&&!flag){
                times.add(tTime);
                news.add(tId);
            }
            else if(times.size()>10&&news.size()>10){
                times.remove(times.size()-1);
                news.remove(news.size()-1);
            }
        }
        return news;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> temp;
        if(followers.containsKey(followerId)){
            temp=new HashSet<>(followers.get(followerId));
            if(!temp.contains(followeeId)) {
                temp.add(followeeId);
                followers.put(followerId,temp);
            }
        }else{
            temp=new HashSet<>();
            if(!temp.contains(followeeId)) {
                temp.add(followeeId);
                followers.put(followerId,temp);
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> temp;
        if(followers.containsKey(followerId)){
            temp=new HashSet<>(followers.get(followerId));
            if(temp.contains(followeeId)) {
                temp.remove(followeeId);
                followers.put(followerId,temp);
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
