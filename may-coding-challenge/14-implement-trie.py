# Implement a trie with insert, search, and startsWith methods.

# Example:

# Trie trie = new Trie();

# trie.insert("apple");
# trie.search("apple");   // returns true
# trie.search("app");     // returns false
# trie.startsWith("app"); // returns true
# trie.insert("app");   
# trie.search("app");     // returns true
# Note:

# You may assume that all inputs are consist of lowercase letters a-z.
# All inputs are guaranteed to be non-empty strings.

ALPHABET_SIZE = 26

class TrieNode:
    def __init__(self):
        self.children = [None] * ALPHABET_SIZE
        self.endOfWord = False
        
class Trie:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur_node = self.root
        for char in word:
            next_node = cur_node.children[ord(char)-ord('a')]
            if next_node is None:
                next_node = TrieNode()
                cur_node.children[ord(char)-ord('a')] = next_node
            cur_node = next_node
        
        cur_node.endOfWord = True
            

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur_node = self.root
        for char in word:
            next_node = cur_node.children[ord(char)-ord('a')]
            if next_node is None:
                return False
            cur_node = next_node
        
        return cur_node.endOfWord
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur_node = self.root
        for char in prefix:
            next_node = cur_node.children[ord(char)-ord('a')]
            if next_node is None:
                return False
            cur_node = next_node
        
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)