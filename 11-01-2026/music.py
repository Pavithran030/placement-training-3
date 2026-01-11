"""

AI Music Playlist Generator
    You're building a feature for a music app that creates mini playlists of 3 songs based on a simple rule:

        No two consecutive songs can be from the same genre.

    You’re given:

        A list of available songs, each with "title" and "genre"
        The user’s starting song (guaranteed to be in the list)
    
        songs = [
            {"title": "Blinding Lights", "genre": "Pop"},
            {"title": "Bohemian Rhapsody", "genre": "Rock"},
            {"title": "Sicko Mode", "genre": "Hip-Hop"},
            {"title": "Take Five", "genre": "Jazz"},
            {"title": "Uptown Funk", "genre": "Funk"},
            {"title": "Shape of You", "genre": "Pop"}
        ]

        start_song = "Blinding Lights"  # genre: Pop
    🎯 Task
        Write a function generate_playlist(songs, start_song) that:
"""
            # Returns a list of 3 song titles starting with start_song
            # Each next song must be from a different genre than the previous one
            # Songs can’t repeat in the playlist
            # If multiple choices exist, pick the first valid one in the list
            # If it’s impossible to make 3 songs, return the shortest possible (at least 1)



class Music:
    temp=[]

    def __init__(self,songs,user):
        self.song=songs
        self.user=user

    def paylist(self,songs,user):
        for i in songs:
            if(i['title']==user):
                self.temp.append(i['title'])
                last_genre=i['genre']
                break
        
        for i in songs:
            if(len(self.temp)==3):
                break
            if(i['genre']!=last_genre and i['title'] not in self.temp):
                self.temp.append(i['title'])
                last_genre=i['genre']
        return self.temp
    

songs = [
            {"title": "Blinding Lights", "genre": "Pop"},
            {"title": "Bohemian Rhapsody", "genre": "Rock"},
            {"title": "Sicko Mode", "genre": "Hip-Hop"},
            {"title": "Take Five", "genre": "Jazz"},
            {"title": "Uptown Funk", "genre": "Funk"},
            {"title": "Shape of You", "genre": "Pop"}
        ]


user=input("Enter the Title Name : ")
mus=Music(songs,user)
store=mus.paylist(songs,user)
print("\nGenerated Playlist: ",store)
