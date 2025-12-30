"""
    Scenario: Social Media Hashtag Analyzer
    You’re building a tool to analyze trending topics from a list of user posts.
    Each post is a string that may contain hashtags (words starting with #, like #Python, #AI).

    You’re given a list of posts:

    posts = [
        "Loving my new #Python project! #coding",
        "Excited about #AI and #MachineLearning",
        "Just finished a tutorial on #Python and #AI",
        "No hashtags here!",
        "#QuantumComputing is the future! #AI #Python"
    ]
    ✅ Hashtags:

    Start with #
    Are followed by letters or digits only (no spaces or punctuation)
    Are case-insensitive for counting (#Python == #python)
    🎯 Your Task
    Write a function top_hashtag(posts) that:

    Extracts all valid hashtags from all posts
    Counts them case-insensitively
    Returns the most frequently used hashtag (in lowercase)
    If there’s a tie, return any one of the top hashtags
    If no hashtags exist, return None


"""

class HashtagAnalyzer:

    def __init__(self,store):
        self.hashcount = store
    def tophash(self,posts):
        for post in posts:
            words = post.split()
            for word in words:
                if word.startswith('#') and word[1:].isalnum():
                    hashtag = word[1:].lower()
                    if hashtag in self.hashcount:
                        self.hashcount[hashtag] += 1
                    else:
                        self.hashcount[hashtag] = 1

    
posts = [
        "Loving my new #Python project! #coding",
        "Excited about #AI and #MachineLearning",
        "Just finished a tutorial on #Python and #AI",
        "No hashtags here!",
        "#QuantumComputing is the future! #AI #Python"
    ]
store={}
ht=HashtagAnalyzer(store)
ht.tophash(posts)
top_hashtag = max(store, key=store.get)
print(top_hashtag," ",store[top_hashtag])
    



