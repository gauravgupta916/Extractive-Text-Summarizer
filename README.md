# Extractive Text Summarizer using JAVA

We all interact with applications which uses text summarization. Many of those applications are for the platform which publishes articles on daily news, entertainment, sports. With our busy schedule, we prefer to read the summary of those article before we decide to jump in for reading entire article. Reading a summary help us to identify the interest area, gives a brief context of the story.

There are basically two techniques when it comes to text summarization:
- Abstractive
- Extractive

### Abstractive Summarization:
Abstractive methods select words based on semantic understanding, even those words did not appear in the source documents. It aims at producing important material in a new way. They interpret and examine the text using advanced natural language techniques in order to generate a new shorter text that conveys the most critical information from the original text. It can be correlated to the way human reads a text article or blog post and then summarizes in their own word.

### Extractive Summarization:
Extractive methods attempt to summarize articles by selecting a subset of words that retain the most important points. This approach weights the important part of sentences and uses the same to form the summary. Different algorithm and techniques are used to define weights for the sentences and further rank them based on importance and similarity among each other.

### Why did I choose Extractive Summarizer over its Abstractive counterpart ?
The limited study is available for abstractive summarization as it requires a deeper understanding of the text as compared to the extractive approach.
Purely extractive summaries often times give better results compared to automatic abstractive summaries. This is because of the fact that abstractive summarization methods cope with problems such as semantic representation, inference and natural language generation which is relatively harder than data-driven approaches such as sentence extraction.

## Table of Contents
- Reading Text Passage from .txt file
- Data preprosessing
- Algorithm
- Results

### Reading Text Passage from .txt file
Use FileInputStream class to read text data from a .txt file. Accumulate all the words in a string variable with the help of Scanner class.

### Data preprosessing
- Generate all stopwords pertaining to the english vocabulary.
- Split the text into sentences.
- Remove stopwords from the sentences.

Here onwards I shall be refering to these sentences as filtered sentences.

### Algorithm
##### TF-IDF for assigning weights to every word:
TF-IDF stands for “Term Frequency — Inverse Document Frequency”. This is a technique to quantify words in a set of documents. We generally compute a score for each word to signify its importance in the document and corpus. It is one of the most important techniques used for information retrieval to represent how important a specific word or phrase is to a given document.
TF-IDF = Term Frequency (TF) * Inverse Document Frequency (IDF)
*Term Frequency* -
This measures the frequency of a word in a document. This highly depends on the length of the document and the generality of the word,
*IDF* -
It is the inverse of the document frequency which measures the informativeness of term t. When we calculate IDF, it will be very low for the most occurring words such as stop words (because they are present in almost all of the documents, and N/df will give a very low value to that word). This finally gives what we want, a relative weightage.

- find all the unique words in the document from filteredSentences.
- calculate the number of sentences in which each word appears in the entire filtered passage.
- calculate term frequency of each sentence.
- calculate idf
- calculate score of each sentence where score = (tf * idf) for that word
- find the threshold score ,i.e., average of all scores.
- get the sentences with score more than the threshold score

### Result
- Sentences in Original passage
- Sentences in summary
- % sentences reduced


### Original Passage :-

It is not always possible for the common people to visit remote jungles or famous national parks to watch various animals. It is very difficult to spot all of these animals in their natural habitats. Also, it is very dangerous for people to take their children for forest safaris to watch animals, birds, reptiles, etc. So, they prefer visiting a zoo, and it is very entertaining for them to watch various animals in the zoo, with all the protection.
There is a wide variety of animals, birds, and beasts that are kept in cages in a zoo. Zoo also keeps animals of rare species. Many animals and birds are brought from foreign lands. This gives the visitors an opportunity to watch such animals and birds of rare species brought from foreign lands, which they could have never seen otherwise.
An African lion, a kangaroo from Australia, the gorilla, the chimpanzee, the zebra, the white tiger, the white peacocks, the polar bear, the different varieties of parrots and parakeets, the huge pythons, or the giant crocodiles all of these amazing animals from so many different terrains and climatic zones are nurtured and kept in a zoo.
Zoos are in fact helping to save such animals and birds that may become extinct in this world. The species that are being threatened or endangered get to be saved in the zoo. There are almost a thousand species of animals, birds, and beasts that are kept in the zoo. Some of the zoos take up breeding culture, specifically captive breeding. This is a huge help in preserving the endangered species, which prevents them from becoming extinct.
These zoos and their maintenance actually show that mankind has an immense love for animals. Man cannot ignore the fact that these animals, birds, reptiles, and beasts are a part of nature. People get to see the variety of animals that exist on this earth. People get to interact, learn and grow with these species of animals.
Visiting a zoo brings human beings closer to these living beings. It makes human beings develop a liking for animals and birds. They get to learn so much about these animals too. Zoos have an aspect of geographical importance as well. They play a vital role in uniting and educating different communities. When we as visitors watch a species of an animal brought from a foreign land, we get to learn about how and where these animals live, about the climate, and the habitat in which they thrive naturally.
The maintenance of a zoo is a huge task. Animals, birds, reptiles, and fishes, from foreign lands with different climatic conditions are to be kept in such surroundings, climate, and temperature that matches that of their natural habitat. If that arrangement is not done properly these animals would not survive. The tigers or lions need to have a waterbody to cool themselves in hot summers. A gorilla or a chimpanzee needs trees and lush green lands to roam around.
All these animals also need to be fed according to their original tastes and appetites. A leopard, a lion, or a tiger has to be served its due quantity of raw meat for every meal. A gorilla or a monkey should be served a vegetarian diet. There are some animals that are to be fed with fish. The python is capable of devouring a whole goat and so, it should be fed accordingly, without harming any other living being around it.
Visiting a zoo is not only fun, but it also teaches us a lot of things. It gives us immense knowledge about the habits and tastes of various animals, beasts, and birds. A zoo needs to have its own medical staff and veterinary doctors who are qualified, efficient, and competent. The animals in the zoo are affected by many diseases. If these diseases start spreading, they might prove to be fatal to the zoo as a whole. Sometimes these animals undergo major surgeries and treatments for the ailments. All of it has to be taken care of in a zoo.
We visitors, at times, cause a great deal of risk to the lives of these animals and birds. Out of excitement, to feed the animals, we throw food in plastic bags to the animals inside their cages. The animals tend to swallow the plastic bags along with the food. The plastic gets stuck in their intestines and causes serious problems, and can even result in death sometimes. Along with this, to get some entertainment, the visitors sometimes risk their own lives. Out of curiosity, the visitors try playing around with wild animals, which, if triggered, can become violent.
The visitors coming to zoos, mainly children, should be properly oriented and refrain from such activities. The zoo authorities also have to take care of the mental health of the animals. The animals may develop stereotypic behaviors or even die prematurely if not taken care of properly. Thus, zoological parks help us learn, grow and have fun. They help us bring human beings closer to nature. We get to understand and live God's beautiful creations through these parks.



### Summary :- 

It is not always possible for the common people to visit remote jungles or famous national 
parks to watch various animals It is very difficult to spot all of these animals in 
their natural habitats Also  it is very dangerous for people to take their children for 
forest safaris to watch animals  birds  reptiles  etc An African lion  a 
kangaroo from Australia  the gorilla  the chimpanzee  the zebra  the white tiger 
 the white peacocks  the polar bear  the different varieties of parrots and parakeets 
 the huge pythons  or the giant crocodiles all of these amazing animals from so 
many different terrains and climatic zones are nurtured and kept in a zoo Zoos are in 
fact helping to save such animals and birds that may become extinct in this world Some 
of the zoos take up breeding culture  specifically captive breeding These zoos and their maintenance 
actually show that mankind has an immense love for animals Visiting a zoo brings human beings 
closer to these living beings Zoos have an aspect of geographical importance as well They play 
a vital role in uniting and educating different communities Animals  birds  reptiles  and 
fishes  from foreign lands with different climatic conditions are to be kept in such surroundings 
 climate  and temperature that matches that of their natural habitat If that arrangement is 
not done properly these animals would not survive The tigers or lions need to have a 
waterbody to cool themselves in hot summers A gorilla or a chimpanzee needs trees and lush 
green lands to roam around All these animals also need to be fed according to their 
original tastes and appetites A leopard  a lion  or a tiger has to be 
served its due quantity of raw meat for every meal A gorilla or a monkey should 
be served a vegetarian diet The python is capable of devouring a whole goat and so 
 it should be fed accordingly  without harming any other living being around it A 
zoo needs to have its own medical staff and veterinary doctors who are qualified  efficient 
 and competent If these diseases start spreading  they might prove to be fatal to 
the zoo as a whole Sometimes these animals undergo major surgeries and treatments for the ailments 
The plastic gets stuck in their intestines and causes serious problems  and can even result 
in death sometimes Out of curiosity  the visitors try playing around with wild animals  
which  if triggered  can become violent The animals may develop stereotypic behaviors or even 
die prematurely if not taken care of properly They help us bring human beings closer to 
nature We get to understand and live God's beautiful creations through these parks 


*Sentences in Original passage = 53*

*Sentences in summary = 26*

*% sentences reduced = 50.943396226415096 %*
