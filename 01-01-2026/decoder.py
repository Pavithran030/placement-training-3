"""

    Scenario: Secret Message Decoder
    
        You've intercepted a series of encrypted messages from a (friendly!) puzzle club.
        Each message is a string of words, but the real hidden message is formed by taking the first letter of every word that has an even number of letters.

    🔍 Example:
        Message: "Help every nice person solve daily riddles"

            "Help" → 4 letters (even) → take 'H'
            "every" → 5 → skip
            "nice" → 4 → take 'n'
            "person" → 6 → take 'p'
            "solve" → 5 → skip
            "daily" → 5 → skip
            "riddles" → 7 → skip
            🔑 Hidden code: "Hnp"
        But wait—you only care about uppercase or lowercase consistency, so you’ll return the secret in all uppercase.

    🎯 Your Task

            Write a function decode_secret(message) that:

            Splits the message into words
            For each word, checks if its length is even
            If yes, takes the first character
            Combines all those first letters → converts to uppercase
            Returns the final secret string
            ✅ If no word has even length, return an empty string ""

"""

class SecretMessageDecoder:

    def __init__(self,message):
        self.message = message

    def decode_secret(self):
        words = self.message.split()
        secret_chars = []
        for word in words:
            if len(word) % 2 == 0:
                secret_chars.append(word[0])
        secret_message = ''.join(secret_chars).upper()
        return secret_message   
    
message = "Help every nice person solve daily riddles"
decoder = SecretMessageDecoder(message) 
secret = decoder.decode_secret()
print("Decoded secret message:", secret)