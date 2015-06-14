import tweepy
import random
 
class TweetBot:
    def __init__(self):
        consumer_key = "REMOVED"
        consumer_secret = "REMOVED"
        access_token = "REMOVED"
        access_token_secret = "REMOVED"
        
        auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
        auth.set_access_token(access_token, access_token_secret)
        self.api = tweepy.API(auth)
 
    def tweet(self, message):
        self.api.update_status(status=message)

 
if __name__ == "__main__":
    twitter = TweetBot()
    task = random.choice(list(open('tasks.txt')))
    twitter.tweet("Hi, @diezcamille! Here's your task for this week:\n" + task)