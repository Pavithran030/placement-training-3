"""
You're planning a movie night with friends. Each person votes for their top 3 favorite genres (in order of preference).
You want to find the most popular genre overall—but with a twist:

    1st choice = 3 points
    2nd choice = 2 points
    3rd choice = 1 point

You’re given a list of votes like this:
    votes = [
    {"name": "Sam", "preferences": ["Action", "Comedy", "Sci-Fi"]},
    {"name": "Taylor", "preferences": ["Comedy", "Drama", "Action"]},
    {"name": "Jordan", "preferences": ["Sci-Fi", "Action", "Comedy"]},
    {"name": "Casey", "preferences": ["Drama", "Comedy", "Action"]}
]

Write a function find_best_genre(votes) that:

Calculates the total points for each genre
Returns the genre with the highest score
If there’s a tie, return any one of the top genres (or the first one encountered).

"""

class Movie:
    def __init__ (self,votes):
        self.vote=votes

    def genre(self):
        score={}
        points=[3,2,1]
        for v in self.vote:
            prefs=v["preferences"]
            for i in range(3):
                genre = prefs[i]
                if genre in score:
                    score[genre] += points[i]
                else:
                    score[genre] = points[i]

        # print(score)
        max_score=-1
        best_genre=""
        for genre,points in score.items():
            if points>max_score:
                max_score=points
                best_genre=genre

        print(f"Best genre: {best_genre} with {max_score} points")


votes = [
    {"name": "Sam", "preferences": ["Action", "Comedy", "Sci-Fi"]},
    {"name": "Taylor", "preferences": ["Comedy", "Drama", "Action"]},
    {"name": "Jordan", "preferences": ["Sci-Fi", "Action", "Comedy"]},
    {"name": "Casey", "preferences": ["Drama", "Comedy", "Action"]}
]

mo=Movie(votes)
mo.genre()