TF-IDF Scorer
=================
The main goal of the assignment is to give you experience calculating the TF-IDF score for a query given a set of documents.

This example *is somewhat different* from what you will need to do for Project 2. This will give you experience with calculating the values, but you will need to make many changes to use this code with your `InvertedIndex` data structure.

The [Term Frequency-Inverse Document Frequency](http://www.tfidf.com/) score gives a measure of the importance of a word (or multi-word query) in a document. Suppose you have 10 documents and you search for a word that appears in only five of the documents. Does that mean that all five are equally relevant to your query? No. TF-IDF is one way to determine which documents are more relevant for a particular query.

Specifically, the *term frequency* gives a measure of how important a word is in a document. If it appears frequently in the document it will be deemed more important (have a higher TF value). The *inverse document frequency* gives a measure of how important a word is across the corpus (or set of documents). If it appears in many documents it will have a lower score. A word like "the" will appear very often in many documents. It will have a high TF but a low IDF. Suppose you have only one document in your corpus about antelopes. The word "antelope" will have a high TF score for the document in which it appears and a high IDF score to indicate it is seen in only a few documents.

The TFIDF is calculated as follows:

```
TF = number of times word occurs in a document / total number of words in the document
IDF = log(total number of documents / number of documents containing the word)
```

For a multi-word query, the TFIDF score for the query in a document is the sum of the scores for each word.

For this assignment, you will implement a method that will take as input a query, possibly of multiple words, and an ArrayList of HashMaps where each HashMap represents a document. The map will map a word to an integer that represents the number of times the word was seen in the document. You will return an ArrayList of scores (doubles) where the score at position 0 is the TF-IDF score for the query in the document at position 0 of the input ArrayList.

Here is an example from [tfidf.com](http://www.tfidf.com/):

```
"Consider a document containing 100 words wherein the word cat appears 3 times. The term frequency (i.e., tf) for cat is then (3 / 100) = 0.03. Now, assume we have 10 million documents and the word cat appears in one thousand of these. Then, the inverse document frequency (i.e., idf) is calculated as log(10,000,000 / 1,000) = 4. Thus, the Tf-idf weight is the product of these quantities: 0.03 * 4 = 0.12."
```

To extend the example, if another document containing the word cat had 100 words and cat appeared 10 times, the TFIDF score for this document would be (10/100) * 4 = .4. Note that the IDF does not change if the query is the same. In this case, the TFIDF score for the document that contains the word cat more often is higher.

